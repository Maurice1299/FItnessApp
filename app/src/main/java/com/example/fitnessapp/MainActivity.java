package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

// The Main Activity class is used to setup the startup screen.
public class MainActivity extends AppCompatActivity {

    Button startBtn;
    Intent v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.start);

        v2 = new Intent(this, CreateUser.class);

        // When the Start button is clicked, go to the Create User view.
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.this.startActivity(v2);
            }
        });
    }
}