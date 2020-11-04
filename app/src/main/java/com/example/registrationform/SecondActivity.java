package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView name, email, phone, dob, address, gender, languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);
        phone = findViewById(R.id.userPhone);
        dob = findViewById(R.id.userDOB);
        gender = findViewById(R.id.userGender);
        languages = findViewById(R.id.userLanguages);
        address = findViewById(R.id.userAddress);

        String enteredName = getIntent().getStringExtra("name");
        String enteredEmail = getIntent().getStringExtra("email");
        String enteredPhone = getIntent().getStringExtra("phone");
        String enteredDOB = getIntent().getStringExtra("dob");
        String enteredAddress = getIntent().getStringExtra("address");
        String enteredGender = getIntent().getStringExtra("gender");
        String enteredLanguage = getIntent().getStringExtra("language");

        name.setText(enteredName);
        email.setText(enteredEmail);
        phone.setText(enteredPhone);
        dob.setText(enteredDOB);
        address.setText(enteredAddress);
        gender.setText(enteredGender);
        languages.setText(enteredLanguage);

    }
}