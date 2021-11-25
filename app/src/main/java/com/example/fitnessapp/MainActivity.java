package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase db;
    DBHelper fDbHelper;

    Button startBtn;
    Intent v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.start);

        v2 = new Intent(this, CreateUser.class);

        fDbHelper = new DBHelper(MainActivity.this);
        try {
            fDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }

        try {

            fDbHelper.openDataBase();

        } catch (SQLException sqle) {

        }
        db = fDbHelper.getWritableDatabase();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.this.startActivity(v2);
            }
        });
    }
}