package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

// The Previous Workout Results class is used to display the user details in a ListView given a type of workout
// that is selected from the Spinner.
public class PreviousWorkoutResults extends AppCompatActivity {

    public static SQLiteDatabase fitnessDB;
    DBHelper fDbHelper;

    Button homeBtn;
    Spinner workoutSpinner;
    ListView userList;
    Button goBackBtn;

    Intent v1, v3;

    Intent getUser;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter listAdapter;

    String[] typeArr = {"Gain Muscle", "Build Endurance", "Lose Weight"};

    ArrayList<String> resultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_workout_results);

        homeBtn = findViewById(R.id.home);
        workoutSpinner = findViewById(R.id.workoutType);
        userList = findViewById(R.id.LV);
        goBackBtn = findViewById(R.id.goBack);

        // Set the adapter for the spinner
        spinnerAdapter = new ArrayAdapter(PreviousWorkoutResults.this, R.layout.previous_workout_spinner, typeArr);

        workoutSpinner.setAdapter(spinnerAdapter);
        workoutSpinner.setSelection(0);

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);

        getUser = getIntent();

        // Create an empty database
        fDbHelper = new DBHelper(PreviousWorkoutResults.this);
        try {
            fDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }

        // Open the database
        try {

            fDbHelper.openDataBase();

        } catch (SQLException sqle) {

        }
        fitnessDB = fDbHelper.getWritableDatabase();

        // When the Home button is clicked, go back to the Main Activity view.
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PreviousWorkoutResults.this.startActivity(v1);
            }
        });

        // When the Go Back button is clicked, go back to the Select Workout view.
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = getUser.getStringExtra("PersonName");
                String gender = getUser.getStringExtra("PersonGender");
                String ageRange = getUser.getStringExtra("PersonAge");
                String height = getUser.getStringExtra("PersonHeight");
                String weight = getUser.getStringExtra("PersonWeight");

                v3.putExtra("PersonName",name);
                v3.putExtra("PersonGender", gender);
                v3.putExtra("PersonAge", ageRange);
                v3.putExtra("PersonHeight",height);
                v3.putExtra("PersonWeight",weight);

                PreviousWorkoutResults.this.startActivity(v3);
            }
        });

        // When an item is selected from the spinner, match the item with the correct workout type
        // in the workout type array and get the corresponding user details
        workoutSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String userQuery = "select * from User";
                String colName = typeArr[i];
                String workoutQuery = "";

                if (colName.equals("Gain Muscle"))
                {
                    workoutQuery = "select Total_Workout_Time_GM from total_workout_time";
                    getUserDetails(userQuery, workoutQuery, colName);
                }
                else if (colName.equals("Build Endurance"))
                {
                    workoutQuery = "select Total_Workout_Time_BE from total_workout_time";
                    getUserDetails(userQuery, workoutQuery, colName);
                }
                else if (colName.equals("Lose Weight"))
                {
                    workoutQuery = "select Total_Workout_Time_LW from total_workout_time";
                    getUserDetails(userQuery, workoutQuery, colName);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Use the specified query as well as the corresponding column name and column number for the workout type
    // to set up the list view that consists of the user details
    public void getUserDetails(String user, String workout, String colName) {
        Cursor uResult = fitnessDB.rawQuery(user, null);
        uResult.moveToFirst();

        Cursor wResult = fitnessDB.rawQuery(workout, null);
        wResult.moveToFirst();

        resultsList = new ArrayList<String>();

        do {

            resultsList.add("ID: " + uResult.getInt(0) + " | " + "Name: " + uResult.getString(1) + " | " + "Age: " + uResult.getInt(2) + " | " + "Gender: " + uResult.getString(3)
            + " | " + "Weight: " + uResult.getInt(4) + " | " + "Height: " + uResult.getInt(5) + " | " + colName + " Workout Time: " + wResult.getInt(0));

        } while (uResult.moveToNext() && wResult.moveToNext());

        listAdapter = new ArrayAdapter(PreviousWorkoutResults.this, R.layout.previous_workout_list, resultsList);
        userList.setAdapter(listAdapter);
    }
}