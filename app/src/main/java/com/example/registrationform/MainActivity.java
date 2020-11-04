package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, phone, dob, address;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox c, java, python, js, terms;
    Button submit;
    String gender;
    String language = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        phone = findViewById(R.id.et_phone);
        dob = findViewById(R.id.et_dob);
        address = findViewById(R.id.et_address);
        c = findViewById(R.id.cb_c);
        java = findViewById(R.id.cb_java);
        python = findViewById(R.id.cb_python);
        js = findViewById(R.id.cb_javascript);
        terms = findViewById(R.id.cb_terms);
        submit = findViewById(R.id.btn_submit);
        radioGroup = findViewById(R.id.radioGroup);


        submit.setOnClickListener(view -> {
            if (name.getText().toString().isEmpty() | email.getText().toString().isEmpty() | phone.getText().toString().isEmpty() |
                    dob.getText().toString().isEmpty() | address.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else {
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
                } else {
                    if (phone.getText().toString().length() != 10) {
                        Toast.makeText(MainActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!isValidEmail(email.getText().toString())) {
                            Toast.makeText(MainActivity.this, "Enter a valid e-mail ID", Toast.LENGTH_SHORT).show();
                        } else {

                            if (!terms.isChecked()) {
                                Toast.makeText(MainActivity.this, "Please agree to the terms first.", Toast.LENGTH_SHORT).show();
                            } else {

                                if (c.isChecked()) {
                                    language = c.getText().toString();
                                }
                                if (java.isChecked()) {
                                    language = language + " | " + java.getText().toString();
                                }
                                if (python.isChecked()) {
                                    language = language + " | " + python.getText().toString();
                                }
                                if (js.isChecked()) {
                                    language = language + " | " + js.getText().toString();
                                }

                                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                intent.putExtra("name", name.getText().toString());
                                intent.putExtra("email", email.getText().toString());
                                intent.putExtra("phone", phone.getText().toString());
                                intent.putExtra("dob", dob.getText().toString());
                                intent.putExtra("address", address.getText().toString());
                                intent.putExtra("gender", gender);
                                intent.putExtra("language", language);
                                startActivity(intent);

                                finish();

                            }
                        }
                    }
                }

            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void checkGender(View v) {
        int id = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(id);
        gender = radioButton.getText().toString();
    }

}