package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WorkoutDetails extends AppCompatActivity {

    Button homeBtn;
    Button goBackBtn;
    Button startWorkoutBtn;
    TextView workoutLabel;
    TextView description;
    WebView workoutWeb;
    ProgressBar webProgress;

    Intent v1,v3,v6;
    Intent getWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        homeBtn = findViewById(R.id.home);
        goBackBtn = findViewById(R.id.goBack);
        startWorkoutBtn = findViewById(R.id.startWorkout);
        workoutLabel = findViewById(R.id.workoutType);
        description = findViewById(R.id.workoutDesc);
        workoutWeb = findViewById(R.id.workoutVideo);
        webProgress = findViewById(R.id.progressBar);

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);
        v6 = new Intent(this, WorkoutSession.class);

        getWorkout = getIntent();
        String workout = getWorkout.getStringExtra("WorkoutType");

        workoutLabel.setText(workout);

        workoutWeb.getSettings().setJavaScriptEnabled(true);

        workoutWeb.setWebViewClient(new WebViewClient());

        if (workout.equals("Lose Weight"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=H3jJ29oE8Zg");
            description.setText("Description for Lose Weight");
        }
        else if (workout.equals("Gain Muscle"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=L-b45afAZws");
            description.setText("Description for Gain Muscle");
        }
        else if (workout.equals("Build Endurance"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=5uVaKjtJHN8");
            description.setText("Description for Build Endurance");
        }

        workoutWeb.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                if (progress == 100)
                {
                    webProgress.setVisibility(View.GONE);
                }
                else
                {
                    webProgress.setVisibility(View.VISIBLE);
                }
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutDetails.this.startActivity(v1);
            }
        });

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutDetails.this.startActivity(v3);
            }
        });

        startWorkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v6.putExtra("WorkoutType", workout);

                WorkoutDetails.this.startActivity(v6);
            }
        });

    }
}