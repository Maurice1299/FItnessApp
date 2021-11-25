package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        getWorkout = getIntent();
        String workout = getWorkout.getStringExtra("WorkoutType");

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v5.putExtra("WorkoutType",workout);
                WorkoutSession.this.startActivity(v5);

            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutSession.this.startActivity(v1);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int totalMinutes = 40-minutes;
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

                            int totalMinutes = 40-minutes;
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

                            int totalMinutes = 40-minutes;
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

                            int totalMinutes = 40-minutes;
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


    }
}