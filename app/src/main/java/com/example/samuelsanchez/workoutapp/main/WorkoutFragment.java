package com.example.samuelsanchez.workoutapp.main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.samuelsanchez.workoutapp.R;
import com.example.samuelsanchez.workoutapp.adapters.WorkoutClickListener;
import com.example.samuelsanchez.workoutapp.adapters.WorkoutsAdapter;
import com.example.samuelsanchez.workoutapp.details.DetailsActivity;
import com.example.samuelsanchez.workoutapp.models.Workout;

/**
 * A placeholder fragment containing a simple view.
 */
public class WorkoutFragment extends Fragment implements WorkoutClickListener {
    public static String WORKOUT_SEND_ID="com.example.samuelsanchez.workoutapp.key.WORKOUT_SEND_ID";
    private WorkoutsAdapter adapter;

    public WorkoutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.WorkoutRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new WorkoutsAdapter(this);
        recyclerView.setAdapter(adapter);

    }
    public void updatelist(Workout workout){
        adapter.update(workout);
        Log.d("e4", workout.getName());
    }


    @Override
    public void clickedId(long id) {
        Intent intent = new Intent(getContext(),DetailsActivity.class);
        intent.putExtra(WORKOUT_SEND_ID,id);
        startActivity(intent);

    }
}
