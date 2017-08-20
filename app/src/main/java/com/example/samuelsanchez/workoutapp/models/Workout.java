package com.example.samuelsanchez.workoutapp.models;

import com.orm.SugarRecord;

/**
 * Created by Samuel Sanchez on 20/8/2017.
 */

public class Workout extends SugarRecord {
    private String name;
    private String description;
    private boolean done;

    public Workout() {

    }

    public Workout(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
