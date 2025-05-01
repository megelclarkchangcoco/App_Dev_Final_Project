package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile); // Set nav_profile as selected

        bottomNavigationView.setOnItemSelectedListener(this::onNavigateItemSelected);
    }

    private boolean onNavigateItemSelected(MenuItem item) {
        Intent intent;
        // Get FULL_NAME to pass to other activities
        String fullName = getIntent().getStringExtra("FULL_NAME");

        if (item.getItemId() == R.id.nav_home) { // Navigate to HomeActivity
            intent = new Intent(this, HomeActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.nav_notifications) { // Navigate to NotificationActivity
            intent = new Intent(this, NotificationActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.nav_statistics) { // Navigate to StatisticsActivity
            intent = new Intent(this, StatisticsActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.nav_tasks) { // Navigate to TasksActivity
            intent = new Intent(this, TasksActivitys.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.nav_profile) {
            // Stay on ProfileActivity
            return true;
        }
        return false;
    }
}