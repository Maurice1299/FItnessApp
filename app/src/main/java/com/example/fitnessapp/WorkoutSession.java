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
    Button pauseBtn;
    Button stopBtn;
    Button startBtn;

    CountDownTimer timer;

    Intent v1,v4, v6;

    Intent getWorkout;

    int seconds = 60;
    int minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_session);

        goBackBtn = findViewById(R.id.goBack);
        homeBtn = findViewById(R.id.home);
        workoutNum = findViewById(R.id.workoutNo);
        time = findViewById(R.id.timer);
        pauseBtn = findViewById(R.id.pause);
        stopBtn = findViewById(R.id.stop);
        startBtn = findViewById(R.id.start);

        v1 = new Intent(this, MainActivity.class);
        v4 = new Intent(this, WorkoutDetails.class);
        v6 = new Intent(this, Results.class);

        getWorkout = getIntent();
        String workout = getWorkout.getStringExtra("WorkoutType");

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WorkoutSession.this.startActivity(v4);

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

                WorkoutSession.this.startActivity(v6);
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
                    time.setText("00:39:00");
                    minutes = 39;
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            seconds--;
                            if (seconds == 0)
                            {
                                //issue: timer skips over 0 and doesn't display it.
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                minutes--;
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

                        }
                    }.start();
                }
                else if (workout.equals("Gain Muscle"))
                {
                    time.setText("00:39:00");
                    minutes = 39;
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            seconds--;
                            if (seconds == 0)
                            {
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                minutes--;
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

                        }
                    }.start();
                }
                else if (workout.equals("Build Endurance"))
                {
                    time.setText("00:39:00");
                    minutes = 39;
                    timer = new CountDownTimer(2400000,1000) {
                        @Override
                        public void onTick(long l) {

                            seconds--;
                            if (seconds == 0)
                            {
                                time.setText("00:"+String.valueOf(minutes)+":00");
                                seconds = 59;
                                minutes--;
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

                        }
                    }.start();
                }


            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}