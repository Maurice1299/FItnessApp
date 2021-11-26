package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity {

    Button goBackBtn;
    Button proceedBtn;
    EditText nameET;
    Spinner genderSP;
    Spinner ageRangeSP;
    EditText heightET;
    EditText weightET;

    String[] genderArr = {"Male", "Female"};
    String[] ageRangeArr = {"14-17", "18-24", "25-35", "36-48", "49+"};
    String gender = "Male";
    String ageRange = "14-17";

    int genderPos=0;
    int ageRangePos=0;

    Intent v1,v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        goBackBtn = findViewById(R.id.goBack);
        proceedBtn = findViewById(R.id.proceed);
        nameET = findViewById(R.id.nameET);
        genderSP = findViewById(R.id.genderSP);
        ageRangeSP = findViewById(R.id.ageRangeSP);
        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);

        v1 = new Intent(this, MainActivity.class);
        v3 = new Intent(this, SelectWorkout.class);

        // Set the Array Adapters for the gender and ageRange spinners or drop-down lists.
        ArrayAdapter genderAdapter, ageRangeAdapter;

        genderAdapter = new ArrayAdapter(CreateUser.this, R.layout.create_user_spinner, genderArr);
        ageRangeAdapter = new ArrayAdapter(CreateUser.this, R.layout.create_user_spinner, ageRangeArr);

        genderAdapter.setDropDownViewResource(R.layout.create_user_spinner);
        ageRangeAdapter.setDropDownViewResource(R.layout.create_user_spinner);

        genderSP.setAdapter(genderAdapter);
        ageRangeSP.setAdapter(ageRangeAdapter);

        genderSP.setSelection(0);
        ageRangeSP.setSelection(0);

        // Keep track of the selected item in the gender spinner
        genderSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                genderPos = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Keep track of the selected item in the ageRange spinner
        ageRangeSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ageRangePos = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Click on the Go Back button to go back to the Main Activity screen
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateUser.this.startActivity(v1);
            }
        });

        // Get the user details that were entered in the text fields or selected from the spinners.
        // If any text field is empty, display the appropriate message to the user.
        // Intent is used to pass the user data to the next view.
        // Click on the Proceed button to proceed to the Select Workout screen.
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameET.getText().toString();
                gender = (String) genderSP.getItemAtPosition(genderPos);
                ageRange = (String) ageRangeSP.getItemAtPosition(ageRangePos);
                String height = heightET.getText().toString();
                String weight = weightET.getText().toString();

                if (name.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_LONG).show();
                }
                else if (height.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Height", Toast.LENGTH_LONG).show();
                }
                else if (weight.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Weight", Toast.LENGTH_LONG).show();
                }
                else
                {
                    v3.putExtra("PersonName",name);
                    v3.putExtra("PersonGender", gender);
                    v3.putExtra("PersonAge", ageRange);
                    v3.putExtra("PersonHeight",height);
                    v3.putExtra("PersonWeight",weight);

                    CreateUser.this.startActivity(v3);
                }


            }
        });
    }
}