package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class PreviousWorkoutResults extends AppCompatActivity {

    Button homeBtn;
    Spinner sessionSpinner;
    TextView workoutTime;
    TextView caloriesBurned;
    TextView BMITV;
    Button goBackBtn;

    Intent v1, v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_workout_results);

        homeBtn = findViewById(R.id.home);
        sessionSpinner = findViewById(R.id.workoutSession);
        workoutTime = findViewById(R.id.totalWorkoutTime);
        caloriesBurned = findViewById(R.id.totalCaloriesBurned);
        BMITV = findViewById(R.id.calculatedBMI);
        goBackBtn = findViewById(R.id.goBack);

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PreviousWorkoutResults.this.startActivity(v1);
            }
        });

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PreviousWorkoutResults.this.startActivity(v3);
            }
        });
    }
}