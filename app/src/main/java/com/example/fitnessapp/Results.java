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
    TextView totalTime;
    TextView totalCalories;
    TextView BMI;

    Intent v1;

    Intent getUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        homeBtn = findViewById(R.id.home);
        totalTime = findViewById(R.id.totalWorkoutTime);
        totalCalories = findViewById(R.id.totalCaloriesBurned);
        BMI = findViewById(R.id.calculatedBMI);

        getUser = getIntent();

        String gender = getUser.getStringExtra("PersonGender");
        String age = getUser.getStringExtra("PersonAge");
        String height = getUser.getStringExtra("PersonHeight");
        String weight = getUser.getStringExtra("PersonWeight");
        int min = getUser.getIntExtra("TotalMin",0);
        int secs = getUser.getIntExtra("TotalSecs",0);

        totalTime.setText("Total Workout Time: " + min +" minutes and "+ secs + " seconds");

        //Calories Burned:
        //For men: 66 + (6.2 x weight) + (12.7 x height) – (6.76 x age)
        //For women: 655.1 + (4.35 x weight) + (4.7 x height) – (4.7 x age)

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

        totalCalories.setText("The total amount of calories you burned is "+calories);

        //BMI = [weight (lb) / height (in) / height (in)] x 703

        float BMIValue = ((Float.parseFloat(weight))/(Float.parseFloat(height))/(Float.parseFloat(height)))*703;

        BMI.setText("Your BMI is "+String.valueOf(BMIValue));

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v1 = new Intent(Results.this, MainActivity.class);

                Results.this.startActivity(v1);
            }
        });



    }
}