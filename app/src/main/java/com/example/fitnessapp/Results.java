package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Results extends AppCompatActivity {

    Button homeBtn;
    Button selectBtn;
    Button startBtn;
    TextView totalTime;
    TextView totalCalories;
    TextView BMI;

    Intent v1,v3,v6;

    Intent getSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        homeBtn = findViewById(R.id.home);
        selectBtn = findViewById(R.id.selectAnotherWorkout);
        startBtn = findViewById(R.id.startSameWorkout);
        totalTime = findViewById(R.id.totalWorkoutTime);
        totalCalories = findViewById(R.id.totalCaloriesBurned);
        BMI = findViewById(R.id.calculatedBMI);

        v1 = new Intent(Results.this, MainActivity.class);
        v3 = new Intent(Results.this, SelectWorkout.class);
        v6 = new Intent(Results.this, WorkoutSession.class);

        getSession = getIntent();

        String gender = getSession.getStringExtra("PersonGender");
        String age = getSession.getStringExtra("PersonAge");
        String height = getSession.getStringExtra("PersonHeight");
        String weight = getSession.getStringExtra("PersonWeight");
        int min = getSession.getIntExtra("TotalMin",0);
        int secs = getSession.getIntExtra("TotalSecs",0);

        totalTime.setText("You worked out for " + min +" minutes and "+ secs + " seconds");

        //Calories Burned:
        //For men: 66 + (6.2 * weight) + (12.7 * height) – (6.76 * age)
        //For women: 655.1 + (4.35 * weight) + (4.7 * height) – (4.7 * age)

        float calories = 0f;

        if (gender.equals("Male"))
        {
            if (age.equals("14-17"))
            {
                calories = (float)(66 + (6.2 * Float.parseFloat(weight)) + (12.7 * Float.parseFloat(height)) - (6.76 * 16));
            }
            else if (age.equals("18-24"))
            {
                calories = (float)(66 + (6.2 * Float.parseFloat(weight)) + (12.7 * Float.parseFloat(height)) - (6.76 * 21));
            }
            else if (age.equals("25-35"))
            {
                calories = (float)(66 + (6.2 * Float.parseFloat(weight)) + (12.7 * Float.parseFloat(height)) - (6.76 * 30));
            }
            else if (age.equals("36-48"))
            {
                calories = (float)(66 + (6.2 * Float.parseFloat(weight)) + (12.7 * Float.parseFloat(height)) - (6.76 * 42));
            }
            else if (age.equals("49+"))
            {
                calories = (float)(66 + (6.2 * Float.parseFloat(weight)) + (12.7 * Float.parseFloat(height)) - (6.76 * 49));
            }
        }
        else if (gender.equals("Female"))
        {
            if (age.equals("14-17"))
            {
                calories = (float)(655.1 + (4.35 * Float.parseFloat(weight)) + (4.7 * Float.parseFloat(height)) - (4.7 * 16));
            }
            else if (age.equals("18-24"))
            {
                calories = (float)(655.1 + (4.35 * Float.parseFloat(weight)) + (4.7 * Float.parseFloat(height)) - (4.7 * 21));
            }
            else if (age.equals("25-35"))
            {
                calories = (float)(655.1 + (4.35 * Float.parseFloat(weight)) + (4.7 * Float.parseFloat(height)) - (4.7 * 30));
            }
            else if (age.equals("36-48"))
            {
                calories = (float)(655.1 + (4.35 * Float.parseFloat(weight)) + (4.7 * Float.parseFloat(height)) - (4.7 * 42));
            }
            else if (age.equals("49+"))
            {
                calories = (float)(655.1 + (4.35 * Float.parseFloat(weight)) + (4.7 * Float.parseFloat(height)) - (4.7 * 49));
            }
        }

        calories = calories * 1.55f;

        totalCalories.setText("You burned a total of "+calories+" calories");

        //BMI = [weight (lb) / height (in) / height (in)] x 703

        float BMIValue = ((Float.parseFloat(weight))/(Float.parseFloat(height))/(Float.parseFloat(height)))*703;

        BMI.setText("Your BMI is "+String.valueOf(BMIValue));

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Results.this.startActivity(v1);
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = getSession.getStringExtra("PersonName");
                String gender = getSession.getStringExtra("PersonGender");
                String ageRange = getSession.getStringExtra("PersonAge");
                String height = getSession.getStringExtra("PersonHeight");
                String weight = getSession.getStringExtra("PersonWeight");


                v3.putExtra("PersonName",name);
                v3.putExtra("PersonGender", gender);
                v3.putExtra("PersonAge", ageRange);
                v3.putExtra("PersonHeight",height);
                v3.putExtra("PersonWeight",weight);

                Results.this.startActivity(v3);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = getSession.getStringExtra("PersonName");
                String gender = getSession.getStringExtra("PersonGender");
                String ageRange = getSession.getStringExtra("PersonAge");
                String height = getSession.getStringExtra("PersonHeight");
                String weight = getSession.getStringExtra("PersonWeight");


                v6.putExtra("PersonName",name);
                v6.putExtra("PersonGender", gender);
                v6.putExtra("PersonAge", ageRange);
                v6.putExtra("PersonHeight",height);
                v6.putExtra("PersonWeight",weight);

                Results.this.startActivity(v6);
            }
        });





    }
}