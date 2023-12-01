package com.example.jasper.manageexpense;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Registration extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextPassword;
    private Button buttonRegister;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_registration);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle registration logic here
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();
                String password = editTextPassword.getText().toString();

                // Call the registration method from DBHelper
                long userId = dbHelper.registerUser(name, email, phone, password);

                if (userId != -1) {
                    // Registration successful
                    Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();

                    // Navigate to the main screen (replace MainActivity.class with your main activity)
                    Intent intent = new Intent(Registration.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity to prevent going back to the registration screen
                } else {
                    // Registration failed
                    Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}