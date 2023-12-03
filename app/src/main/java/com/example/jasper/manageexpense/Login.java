package com.example.jasper.manageexpense;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText editTextLoginEmail, editTextLoginPassword;
    private Button buttonLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        editTextLoginEmail = (EditText) findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login logic here
                String email = editTextLoginEmail.getText().toString();
                String password = editTextLoginPassword.getText().toString();

                // Call the login method from DBHelper
                boolean loginSuccessful = dbHelper.loginUser(email, password);

                if (loginSuccessful) {
                    // Login successful
                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // You can navigate to the main activity here
                  Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Login failed
                    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

