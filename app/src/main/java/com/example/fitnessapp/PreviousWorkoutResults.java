package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PreviousWorkoutResults extends AppCompatActivity {

    Button homeBtn;
    Spinner workoutSpinner;
    ListView userList;
    Button goBackBtn;

    Intent v1, v3;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter listAdapter;

    String[] typeArr = {"Gain Muscle", "Build Endurance", "Lose Weight"};

    ArrayList<Integer> IDList;
    ArrayList<String> nameList;
    ArrayList<String> ageList;
    ArrayList<String> genderList;
    ArrayList<Integer> weightList;
    ArrayList<Integer> heightList;
    ArrayList<Integer> GMTimeList;
    ArrayList<Integer> BETimeList;
    ArrayList<Integer> LWTimeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_workout_results);

        homeBtn = findViewById(R.id.home);
        workoutSpinner = findViewById(R.id.workoutType);
        userList = findViewById(R.id.LV);
        goBackBtn = findViewById(R.id.goBack);

        spinnerAdapter = new ArrayAdapter(PreviousWorkoutResults.this, R.layout.previous_workout_spinner, typeArr);

        workoutSpinner.setAdapter(spinnerAdapter);
        workoutSpinner.setSelection(0);

        listAdapter = new ArrayAdapter(PreviousWorkoutResults.this, R.layout.previous_workout_list, typeArr);

        userList.setAdapter(listAdapter);
        userList.setSelection(0);

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