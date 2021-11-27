package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// The Workout Session class is used to display and control the countdown timer
// as the user is working out.
public class WorkoutSession extends AppCompatActivity {

    Button goBackBtn;
    Button homeBtn;
    TextView workoutNum;
    TextView time;
    Button stopBtn;
    Button startBtn;

    CountDownTimer timer;

    Intent v1,v5, v7;

    Intent getWorkout;

    int seconds = 60;
    int minutes = 39;
    int totalSeconds = 0;
    int totalMinutes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_session);

        goBackBtn = findViewById(R.id.goBack);
        homeBtn = findViewById(R.id.home);
        workoutNum = findViewById(R.id.workoutNo);
        time = findViewById(R.id.timer);
        stopBtn = findViewById(R.id.stop);
        startBtn = findViewById(R.id.start);

        v1 = new Intent(this, MainActivity.class);
        v5 = new Intent(this, WorkoutDetails.class);
        v7 = new Intent(this, Results.class);

        // Use Intent to get the type of workout from the previous view
        getWorkout = getIntent();
        String workout = getWorkout.getStringExtra("WorkoutType");

        // Use Intent to pass the type of workout to the Workout Details view.
        // When the Go Back button gets clicked, go back to the Workout Details view.
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v5.putExtra("WorkoutType",workout);
                WorkoutSession.this.startActivity(v5);

            }
        });

        // When the Home button gets clicked, go back to the Main Activity view.
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutSession.this.startActivity(v1);
            }
        });

        // Set the countdown timer given the type of workout
        if (workout.equals("Lose Weight"))
        {
            time.setText("00:40:00");
        }
        else if (workout.equals("Gain Muscle"))
        {
            time.setText("00:40:00");
        }
        else if (workout.equals("Build Endurance"))
        {
            time.setText("00:40:00");
        }

        // When the Start button gets clicked, start the corresponding countdown timer given the type of workout.
        // For each countdown timer, keep track of the total minutes and total seconds that are elapsed and display the timer correctly.
        // Once the timer is finished, use Intents to get the user details as well as pass the total minutes, total seconds and user details to the Results view.
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (workout.equals("Lose Weight"))
                {
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            totalSeconds++;
                            seconds--;
                            if (seconds == 0)
                            {
                                //issue: timer skips over 0 and doesn't display it.
                                totalMinutes++;
                                minutes--;
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                if (minutes == 0)
                                {
                                    timer.cancel();
                                }
                                else if ((minutes < 10) && (minutes > 0))
                                {
                                    time.setText("00:0"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                                else
                                {
                                    time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                            }
                            else if ((seconds < 10) && (seconds > 0))
                            {
                                time.setText("00:"+String.valueOf(minutes)+":0"+String.valueOf(seconds));
                            }
                            else
                            {
                                time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                            }

                        }

                        @Override
                        public void onFinish() {

                            v7.putExtra("TotalMin",totalMinutes);
                            v7.putExtra("TotalSecs",totalSeconds);

                            String name = getWorkout.getStringExtra("PersonName");
                            String gender = getWorkout.getStringExtra("PersonGender");
                            String ageRange = getWorkout.getStringExtra("PersonAge");
                            String height = getWorkout.getStringExtra("PersonHeight");
                            String weight = getWorkout.getStringExtra("PersonWeight");

                            v7.putExtra("WorkoutType", workout);
                            v7.putExtra("PersonName",name);
                            v7.putExtra("PersonGender", gender);
                            v7.putExtra("PersonAge", ageRange);
                            v7.putExtra("PersonHeight",height);
                            v7.putExtra("PersonWeight",weight);

                            WorkoutSession.this.startActivity(v7);

                        }
                    }.start();
                }
                else if (workout.equals("Gain Muscle"))
                {
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            totalSeconds++;
                            seconds--;
                            if (seconds == 0)
                            {
                                //issue: timer skips over 0 and doesn't display it.
                                totalMinutes++;
                                minutes--;
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                if (minutes == 0)
                                {
                                    timer.cancel();
                                }
                                else if ((minutes < 10) && (minutes > 0))
                                {
                                    time.setText("00:0"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                                else
                                {
                                    time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                            }
                            else if ((seconds < 10) && (seconds > 0))
                            {
                                time.setText("00:"+String.valueOf(minutes)+":0"+String.valueOf(seconds));
                            }
                            else
                            {
                                time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                            }

                        }

                        @Override
                        public void onFinish() {

                            v7.putExtra("TotalMin",totalMinutes);
                            v7.putExtra("TotalSecs",totalSeconds);

                            String name = getWorkout.getStringExtra("PersonName");
                            String gender = getWorkout.getStringExtra("PersonGender");
                            String ageRange = getWorkout.getStringExtra("PersonAge");
                            String height = getWorkout.getStringExtra("PersonHeight");
                            String weight = getWorkout.getStringExtra("PersonWeight");

                            v7.putExtra("WorkoutType", workout);
                            v7.putExtra("PersonName",name);
                            v7.putExtra("PersonGender", gender);
                            v7.putExtra("PersonAge", ageRange);
                            v7.putExtra("PersonHeight",height);
                            v7.putExtra("PersonWeight",weight);

                            WorkoutSession.this.startActivity(v7);

                        }
                    }.start();
                }
                else if (workout.equals("Build Endurance"))
                {
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            totalSeconds++;
                            seconds--;
                            if (seconds == 0)
                            {
                                //issue: timer skips over 0 and doesn't display it.
                                totalMinutes++;
                                minutes--;
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                if (minutes == 0)
                                {
                                    timer.cancel();
                                }
                                else if ((minutes < 10) && (minutes > 0))
                                {
                                    time.setText("00:0"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                                else
                                {
                                    time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                                }
                            }
                            else if ((seconds < 10) && (seconds > 0))
                            {
                                time.setText("00:"+String.valueOf(minutes)+":0"+String.valueOf(seconds));
                            }
                            else
                            {
                                time.setText("00:"+String.valueOf(minutes)+":"+String.valueOf(seconds));
                            }

                        }

                        @Override
                        public void onFinish() {

                            v7.putExtra("TotalMin",totalMinutes);
                            v7.putExtra("TotalSecs",totalSeconds);

                            String name = getWorkout.getStringExtra("PersonName");
                            String gender = getWorkout.getStringExtra("PersonGender");
                            String ageRange = getWorkout.getStringExtra("PersonAge");
                            String height = getWorkout.getStringExtra("PersonHeight");
                            String weight = getWorkout.getStringExtra("PersonWeight");

                            v7.putExtra("WorkoutType", workout);
                            v7.putExtra("PersonName",name);
                            v7.putExtra("PersonGender", gender);
                            v7.putExtra("PersonAge", ageRange);
                            v7.putExtra("PersonHeight",height);
                            v7.putExtra("PersonWeight",weight);

                            WorkoutSession.this.startActivity(v7);

                        }
                    }.start();
                }


            }
        });

        // Use Intents to get the user details as well as pass the total minutes, total seconds and user details to the Results view.
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v7.putExtra("TotalMin",totalMinutes);
                v7.putExtra("TotalSecs",totalSeconds);

                String name = getWorkout.getStringExtra("PersonName");
                String gender = getWorkout.getStringExtra("PersonGender");
                String ageRange = getWorkout.getStringExtra("PersonAge");
                String height = getWorkout.getStringExtra("PersonHeight");
                String weight = getWorkout.getStringExtra("PersonWeight");

                v7.putExtra("WorkoutType", workout);
                v7.putExtra("PersonName",name);
                v7.putExtra("PersonGender", gender);
                v7.putExtra("PersonAge", ageRange);
                v7.putExtra("PersonHeight",height);
                v7.putExtra("PersonWeight",weight);

                WorkoutSession.this.startActivity(v7);
            }
        });


    }
}