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

// The Workout Details class is used to display a video and a text description that would explain the type of workout
// specified by the user in the Select Workout view.
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
        workoutLabel = findViewById(R.id.workoutTxt);
        description = findViewById(R.id.workoutDesc);
        workoutWeb = findViewById(R.id.workoutVideo);
        webProgress = findViewById(R.id.progressBar);

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);
        v6 = new Intent(this, WorkoutSession.class);

        // Use Intent to get the type of workout from the previous view
        getWorkout = getIntent();
        String workout = getWorkout.getStringExtra("WorkoutType");

        // Set the text view to the type of workout that was selected by the user
        workoutLabel.setText(workout);

        // Set up the web view in order to display the workout video to the user
        workoutWeb.getSettings().setJavaScriptEnabled(true);

        workoutWeb.setWebViewClient(new WebViewClient());

        // Ensure the workout video corresponding to the type of workout selected by the user gets displayed
        if (workout.equals("Lose Weight"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=H3jJ29oE8Zg");
            description.setText("In order to lose weight, you need to do the following exercises: forearm plank, sit-ups, knee-high crunches, basic crunches, sit-up and twist, and dorsal raises. You need to do 3 sets of 10 for the sit-ups, knee-high crunches, basic crunches, sit-up and twist, and dorsal raises.");
        }
        else if (workout.equals("Gain Muscle"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=L-b45afAZws");
            description.setText("In order to gain muscle, you need to do plank walkouts, half burpees, leg raises, plank shoulder taps, kneeling plank, reverse crunches, glute bridges, and offset press ups");
        }
        else if (workout.equals("Build Endurance"))
        {
            workoutWeb.loadUrl("https://www.youtube.com/watch?v=5uVaKjtJHN8");
            description.setText("In order to build endurance, you need to do eight exercises for 2 rounds. The eight exercises are lateral hops, squat jumps, ventral hops, burpees, lateral jumps, jumping lunges, agility dots, and mountain climbers. For each exercise, you need to do 16 reps. This training regimen doesn't require any equipment.");
        }

        // When the progress bar's progress is at 100, don't show the progress bar
        // Otherwise, show the progress bar
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

        // When the Home button gets clicked, go back to the Main Activity view
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutDetails.this.startActivity(v1);
            }
        });

        // When the Go Back button gets clicked, go back to the Select Workout view
        // Use Intents to get the user details as well as pass the type of workout and user details to the Select Session view.
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v3.putExtra("WorkoutType", workout);

                String name = getWorkout.getStringExtra("PersonName");
                String gender = getWorkout.getStringExtra("PersonGender");
                String ageRange = getWorkout.getStringExtra("PersonAge");
                String height = getWorkout.getStringExtra("PersonHeight");
                String weight = getWorkout.getStringExtra("PersonWeight");

                v3.putExtra("PersonName",name);
                v3.putExtra("PersonGender", gender);
                v3.putExtra("PersonAge", ageRange);
                v3.putExtra("PersonHeight",height);
                v3.putExtra("PersonWeight",weight);

                WorkoutDetails.this.startActivity(v3);
            }
        });

        // Use Intents to get the user details as well as pass the type of workout and user details to the Workout Session view.
        // When the Start Workout Session button gets clicked, go to the Workout Session view.
        startWorkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v6.putExtra("WorkoutType", workout);

                String name = getWorkout.getStringExtra("PersonName");
                String gender = getWorkout.getStringExtra("PersonGender");
                String ageRange = getWorkout.getStringExtra("PersonAge");
                String height = getWorkout.getStringExtra("PersonHeight");
                String weight = getWorkout.getStringExtra("PersonWeight");

                v6.putExtra("PersonName",name);
                v6.putExtra("PersonGender", gender);
                v6.putExtra("PersonAge", ageRange);
                v6.putExtra("PersonHeight",height);
                v6.putExtra("PersonWeight",weight);

                WorkoutDetails.this.startActivity(v6);
            }
        });

    }
}