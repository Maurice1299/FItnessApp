package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectWorkout extends AppCompatActivity {

    Button proceedBtn;
    Button homeBtn;
    Button viewPreviousBtn;
    RadioGroup rg;

    Intent v1,v4,v5;

    String rbSelected = "Lose Weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workout);

        proceedBtn = findViewById(R.id.proceed);
        homeBtn = findViewById(R.id.home);
        viewPreviousBtn = findViewById(R.id.viewPrevious);
        rg = findViewById(R.id.rGroup);

        v1 = new Intent(this, MainActivity.class);
        v4 = new Intent(this, PreviousWorkoutResults.class);
        v5 = new Intent(this, WorkoutDetails.class);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(i);

                switch(rb.getText().toString()){
                    case "Lose Weight":
                        rbSelected = "Lose Weight";
                        break;
                    case "Gain Muscle":
                        rbSelected = "Gain Muscle";
                        break;
                    case "Build Endurance":
                        rbSelected = "Build Endurance";
                        break;
                }
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectWorkout.this.startActivity(v1);
            }
        });

        viewPreviousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectWorkout.this.startActivity(v4);
            }
        });

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v5.putExtra("WorkoutType",rbSelected);

                SelectWorkout.this.startActivity(v5);

            }
        });
    }
}