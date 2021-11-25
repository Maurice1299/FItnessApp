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

public class PreviousWorkoutResults extends AppCompatActivity {

    public static SQLiteDatabase fitnessDB;
    DBHelper fDbHelper;

    Button homeBtn;
    Spinner workoutSpinner;
    ListView userList;
    Button goBackBtn;

    Intent v1, v3;

    ArrayAdapter spinnerAdapter;
    ArrayAdapter listAdapter;

    String[] typeArr = {"Gain Muscle", "Build Endurance", "Lose Weight"};

    ArrayList<String> resultsList;

    /*ArrayList<Integer> IDList;
    ArrayList<String> nameList;
    ArrayList<Integer> ageList;
    ArrayList<String> genderList;
    ArrayList<Integer> weightList;
    ArrayList<Integer> heightList;
    ArrayList<Integer> GMTimeList;
    ArrayList<Integer> BETimeList;
    ArrayList<Integer> LWTimeList;*/

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

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);

        fDbHelper = new DBHelper(PreviousWorkoutResults.this);
        try {
            fDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }

        try {

            fDbHelper.openDataBase();

        } catch (SQLException sqle) {

        }
        fitnessDB = fDbHelper.getWritableDatabase();

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

        workoutSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String query = "select * from User";
                String colName = typeArr[i];
                int colNum = 0;

                if (typeArr[i].equals("Gain Muscle"))
                {
                    colNum = 6;
                    getUserDetails(query, colName, colNum);
                }
                else if (typeArr[i].equals("Build Endurance"))
                {
                    colNum = 7;
                    getUserDetails(query, colName, colNum);
                }
                else if (typeArr[i].equals("Lose Weight"))
                {
                    colNum = 8;
                    getUserDetails(query, colName, colNum);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void getUserDetails(String q, String colName, Integer colNum) {
        Cursor result = fitnessDB.rawQuery(q, null);
        result.moveToFirst();

        resultsList = new ArrayList<String>();

        /*IDList = new ArrayList<Integer>();
        nameList = new ArrayList<String>();
        ageList = new ArrayList<Integer>();
        genderList = new ArrayList<String>();
        weightList = new ArrayList<Integer>();
        heightList = new ArrayList<Integer>();
        GMTimeList = new ArrayList<Integer>();
        BETimeList = new ArrayList<Integer>();
        LWTimeList = new ArrayList<Integer>();*/

        do {

            resultsList.add("ID: " + result.getInt(0) + " | " + "Name: " + result.getString(1) + " | " + "Age: " + result.getInt(2) + " | " + "Gender: " + result.getString(3)
            + " | " + "Weight: " + result.getInt(4) + " | " + "Height: " + result.getInt(5) + " | " + colName + " Workout Time: " + result.getInt(colNum));

        } while (result.moveToNext());

        listAdapter = new ArrayAdapter(PreviousWorkoutResults.this, R.layout.previous_workout_list, resultsList);
        userList.setAdapter(listAdapter);
    }
}