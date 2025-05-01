package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StatisticsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        // Set up bottom Navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.nav_statistics);

        // Use method reference instead of lambda
        bottomNavigation.setOnItemSelectedListener(this::onNavigationItemSelected);

    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        // Get FULL_NAME to pass to other activities
        String fullName = getIntent().getStringExtra("FULL_NAME");
        if(item.getItemId() == R.id.nav_home){ // Navigate to HomeActivity
            intent = new Intent(this, HomeActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_notifications){ // Navigate to NotificationActivity
            intent = new Intent(this, NotificationActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_statistics){ // Navigate to nav_statistics
            // Stay in StatisticsActivity
            return true;
        }
        else if(item.getItemId() == R.id.nav_tasks) { // Navigate to TasksActivitys
            intent = new Intent(this, TasksActivitys.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.nav_profile){ // Navigate to ProfileActivity
            intent = new Intent(this, ProfileActivity.class);
            if (fullName != null) {
                intent.putExtra("FULL_NAME", fullName);
            }
            startActivity(intent);
            return true;
        }
        return false;
    }
}
