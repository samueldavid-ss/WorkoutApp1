package com.example.samuelsanchez.workoutapp.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.samuelsanchez.workoutapp.R;
import com.example.samuelsanchez.workoutapp.data.Queries;
import com.example.samuelsanchez.workoutapp.models.Workout;

import java.util.List;

/**
 * Created by Samuel Sanchez on 20/8/2017.
 */

public class WorkoutsAdapter extends RecyclerView.Adapter<WorkoutsAdapter.Viewholder> {

    private List<Workout> workouts = new Queries().workouts();
    private WorkoutClickListener listener;

    public WorkoutsAdapter(WorkoutClickListener listener) {
        this.listener = listener;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_intem_workout, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        Workout workout = workouts.get(position);
        holder.textView.setText(workout.getName());
        holder.checkBox.setChecked(workout.isDone());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheacked) {

                if(isCheacked){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxposition = holder.getAdapterPosition();
                            Workout auxWorkout = workouts.get(auxposition);
                            auxWorkout.setDone(true);
                            auxWorkout.save();
                            workouts.remove(auxposition);
                            notifyItemRemoved(auxposition);

                        }
                    },400);
                }

            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Workout auxWorkout = workouts.get(holder.getAdapterPosition());
                listener.clickedId(auxWorkout.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public void update(Workout workout){
        workouts.add(workout);
        notifyDataSetChanged();

    }

    static class Viewholder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView textView;


        public Viewholder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.workoutCb);
            textView = itemView.findViewById(R.id.workoutTv);


        }
    }




}
