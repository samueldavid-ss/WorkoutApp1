package com.example.samuelsanchez.workoutapp.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.samuelsanchez.workoutapp.main.WorkoutFragment;
import com.example.samuelsanchez.workoutapp.R;
import com.example.samuelsanchez.workoutapp.models.Workout;

/**
 * Created by Samuel Sanchez on 20/8/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    private Workout workout;
    private EditText DescriptionET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id = getIntent().getLongExtra(WorkoutFragment.WORKOUT_SEND_ID,0);

        workout = Workout.findById(Workout.class, id);
        Toast.makeText(this, "funciona"+ workout.getName(), Toast.LENGTH_SHORT).show();
        DescriptionET= (EditText) findViewById(R.id.descriptionET);
    }

    @Override
    protected void onPause() {
        super.onPause();
        workout.setDescription(DescriptionET.getText().toString());
        workout.save();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (workout.getDescription() != null){
            DescriptionET.setText(workout.getDescription());
        }
    }

}
