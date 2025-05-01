package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set up Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home); // Conditional to set nav_home as selected

        bottomNavigationView.setOnItemSelectedListener(this::onNavigateItemSelected);

        // Retrieve the full name from the intent safely
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("FULL_NAME");
        String firstName = "";
        if (fullName != null && !fullName.isEmpty()) {
            firstName = fullName.split(" ")[0];
        }
        TextView headerNameText = findViewById(R.id.headerName_text);
        headerNameText.setText(firstName);
    }

    private boolean onNavigateItemSelected(MenuItem item) {
        Intent intent;
        // Get FULL_NAME to pass to other activities
        String fullName = getIntent().getStringExtra("FULL_NAME");

        if (item.getItemId() == R.id.nav_home) {
            // Stay on HomeActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_notifications) { // Navigate to NotificationActivity
            intent = new Intent(this, NotificationActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close HomeActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_statistics) { // Navigate to StatisticsActivity
            intent = new Intent(this, StatisticsActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close HomeActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_tasks) { // Navigate to TasksActivity
            intent = new Intent(this, TasksActivitys.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close HomeActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_profile) { // Navigate to ProfileActivity
            intent = new Intent(this, ProfileActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close HomeActivity
            return true;
        }
        return false;
    }
}