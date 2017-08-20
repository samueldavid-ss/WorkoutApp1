package com.example.samuelsanchez.workoutapp.data;

import com.example.samuelsanchez.workoutapp.models.Workout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel Sanchez on 20/8/2017.
 */

public class Queries {
    public List<Workout> workouts(){
        List<Workout> workouts = new ArrayList<>();
        List<Workout> workoutList = Workout.find(Workout.class, "done = 0" );

        if (workoutList != null && workoutList.size()> 0){
            workouts.addAll(workoutList);
        }
        return workouts;
    }

}
