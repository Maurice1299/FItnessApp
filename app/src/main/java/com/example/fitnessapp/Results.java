package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

// The Results class is used to display the workout results to the user after the workout session is done.
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

        // Use Intent to get the data that was passed from the previous view

        getSession = getIntent();

        String workout = getSession.getStringExtra("WorkoutType");
        String name = getSession.getStringExtra("PersonName");
        String gender = getSession.getStringExtra("PersonGender");
        String age = getSession.getStringExtra("PersonAge");
        String height = getSession.getStringExtra("PersonHeight");
        String weight = getSession.getStringExtra("PersonWeight");
        int min = getSession.getIntExtra("TotalMin",0);
        int secs = getSession.getIntExtra("TotalSecs",0);

        // Display the total workout time to the user
        totalTime.setText("You worked out for " + min +" minutes and "+ secs + " seconds");

        float calories = 0f;

        // Formula for Total Calories Burned:
        // For men: 66 + (6.2 * weight) + (12.7 * height) – (6.76 * age)
        // For women: 655.1 + (4.35 * weight) + (4.7 * height) – (4.7 * age)

        // If the user is Male with a specified age range, calculate the total amount of calories burned using the given formula
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
        // If the user is Female with a specified age range, calculate the total amount of calories burned using the given formula
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

        // Display the total amount of calories burned to the user
        totalCalories.setText("You burned a total of "+calories+" calories");

        // BMI Formula: BMI = [weight (lb) / height (in) / height (in)] x 703

        // Calculate the BMI using the given formula
        float BMIValue = ((Float.parseFloat(weight))/(Float.parseFloat(height))/(Float.parseFloat(height)))*703;

        // Display the calculated BMI to the user
        BMI.setText("Your BMI is "+String.valueOf(BMIValue));

        // When the Home button is clicked, go back to the Main Activity view
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Results.this.startActivity(v1);
            }
        });

        // When the Select Another Workout button is clicked, go back to the Select Workout view
        // after using Intent to pass user details
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v3.putExtra("PersonName",name);
                v3.putExtra("PersonGender", gender);
                v3.putExtra("PersonAge", age);
                v3.putExtra("PersonHeight",height);
                v3.putExtra("PersonWeight",weight);

                Results.this.startActivity(v3);
            }
        });

        // When the Start the Same Workout button is clicked, go back to the Workout Session view
        // after using Intent to pass user details
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v6.putExtra("WorkoutType", workout);
                v6.putExtra("PersonName",name);
                v6.putExtra("PersonGender", gender);
                v6.putExtra("PersonAge", age);
                v6.putExtra("PersonHeight",height);
                v6.putExtra("PersonWeight",weight);

                Results.this.startActivity(v6);
            }
        });





    }
}