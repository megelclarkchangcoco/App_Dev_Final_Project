package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText registerName, registerPhone, registerUsername, registerPassword;
    TextView toSigninbutton;
    Button registerButton;
    databaseConnection dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the database connection
        dbConnection = new databaseConnection(this);

        // Initialize the UI elements
        registerName = findViewById(R.id.registerName_input);
        registerPhone = findViewById(R.id.registerPhonenumber_input);
        registerUsername = findViewById(R.id.registerUsername_input);
        registerPassword = findViewById(R.id.registerPassword_input);
        registerButton = findViewById(R.id.registerSignup_button);
        toSigninbutton = findViewById(R.id.toSignin_button);

        // OnClickListener for Register Button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the input from the EditText fields
                String strRegisterName = registerName.getText().toString();
                String strRegisterPhone = registerPhone.getText().toString();
                String strRegisterUsername = registerUsername.getText().toString();
                String strRegisterPassword = registerPassword.getText().toString();

                // Validate input
                if (strRegisterName.isEmpty() || strRegisterPhone.isEmpty() ||
                        strRegisterUsername.isEmpty() || strRegisterPassword.isEmpty()) {
                    // Show a message if any field is empty
                    Toast.makeText(RegisterActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a new Users object with the input data
                    Users newUser = new Users(null, strRegisterName, strRegisterPhone, strRegisterUsername, strRegisterPassword);

                    // Add the user to the database
                    dbConnection.addUsers(newUser);

                    // Log the successful registration
                    Log.d("RegisterActivity", "User registered: " + newUser.getFullname() + ", " + newUser.getUsername());

                    // Show a success message
                    Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();

                    // Navigate to LoginActivity after successful registration
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        // OnClickListener for the "Go to Signin" text view
        toSigninbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the login activity when the "Go to Signin" button is clicked
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
