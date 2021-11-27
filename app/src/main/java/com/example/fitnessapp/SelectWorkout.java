package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// The Select Workout class allows the user to select a type of workout.
public class SelectWorkout extends AppCompatActivity {

    Button proceedBtn;
    Button homeBtn;
    Button viewPreviousBtn;
    RadioGroup rg;

    Intent v1,v4,v5;

    Intent getUser;

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

        // Keep track of the selected workout type by checking which radio button gets checked
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

        // When the Home button gets clicked, go back to the Main Activity view
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectWorkout.this.startActivity(v1);
            }
        });

        // When the View Previous Workout Sessions button gets clicked, go to the Previous Workout Results view
        viewPreviousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectWorkout.this.startActivity(v4);
            }
        });

        // Use Intents to get the user details as well as pass the type of workout and user details to the Select Workout view.
        // When the Proceed to Workout button gets clicked, go to the Select workout view.
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v5.putExtra("WorkoutType",rbSelected);

                getUser = getIntent();

                String name = getUser.getStringExtra("PersonName");
                String gender = getUser.getStringExtra("PersonGender");
                String ageRange = getUser.getStringExtra("PersonAge");
                String height = getUser.getStringExtra("PersonHeight");
                String weight = getUser.getStringExtra("PersonWeight");


                v5.putExtra("PersonName",name);
                v5.putExtra("PersonGender", gender);
                v5.putExtra("PersonAge", ageRange);
                v5.putExtra("PersonHeight",height);
                v5.putExtra("PersonWeight",weight);

                SelectWorkout.this.startActivity(v5);

            }
        });
    }
}