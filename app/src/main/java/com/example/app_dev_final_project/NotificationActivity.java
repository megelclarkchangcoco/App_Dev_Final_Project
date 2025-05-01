package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Set up Bottom Navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.nav_notifications); // Set default selected item

        bottomNavigation.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        String fullName = getIntent().getStringExtra("FULL_NAME");

        if (item.getItemId() == R.id.nav_home) {
            intent = new Intent(this, HomeActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close NotificationActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_notifications) {
            // Stay in NotificationActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_statistics) {
            intent = new Intent(this, StatisticsActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close NotificationActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_tasks) {
            intent = new Intent(this, TasksActivitys.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close NotificationActivity
            return true;
        }
        if (item.getItemId() == R.id.nav_profile) {
            intent = new Intent(this, ProfileActivity.class);
            // Check if the FULL_NAME extra exists in the current activity's intent
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            finish(); // Close NotificationActivity
            return true;
        }
        return false;
    }
}