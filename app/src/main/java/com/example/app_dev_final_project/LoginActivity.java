package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    TextView toSignupButton;
    Button toLoginButton;
    databaseConnection dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Initialize the database connection
        dbConnection = new databaseConnection(this);

        // Initialize UI components
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        toLoginButton = findViewById(R.id.login_button);
        toSignupButton = findViewById(R.id.toSignup_button);

        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                // Check for empty fields
                if (strUsername.isEmpty() || strPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in both username and password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verify credentials
                String fullName = dbConnection.checkLogin(strUsername, strPassword);
                if (fullName != null) {
                    // Login successful, navigate to HomeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("FULL_NAME", fullName); // Pass full name to HomeActivity
                    startActivity(intent);
                    finish(); // Close LoginActivity
                } else {
                    // Invalid credentials
                    Toast.makeText(LoginActivity.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Navigate to sign up activity
        toSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}