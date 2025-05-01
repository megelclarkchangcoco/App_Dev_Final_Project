package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set up Bottom Navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.nav_home); // Set default selected item
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.nav_home) {
            // Stay in HomeActivity
            return true;
        } else if (item.getItemId() == R.id.nav_notifications) {
            intent = new Intent(this, NotificationActivity.class); // Open NotificationActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_statistics) {
            intent = new Intent(this, StatisticsActivity.class); // Open StatisticsActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_tasks) {
            intent = new Intent(this, TasksActivitys.class); // Open TasksActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_profile) {
            intent = new Intent(this, ProfileActivity.class); // Open ProfileActivity
            startActivity(intent);
            return true;
        }
        return false;
    }
}
