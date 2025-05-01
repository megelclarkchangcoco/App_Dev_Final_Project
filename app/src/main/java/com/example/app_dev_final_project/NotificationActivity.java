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

        // Use the updated setOnItemSelectedListener
        bottomNavigation.setOnItemSelectedListener(item -> onNavigationItemSelected(item));
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.nav_home) {
            intent = new Intent(this, HomeActivity.class); // Navigate to HomeActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_notifications) {
            // Stay in NotificationActivity
            return true;
        } else if (item.getItemId() == R.id.nav_statistics) {
            intent = new Intent(this, StatisticsActivity.class); // Navigate to StatisticsActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_tasks) {
            intent = new Intent(this, TasksActivitys.class); // Navigate to TasksActivity
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.nav_profile) {
            intent = new Intent(this, ProfileActivity.class); // Navigate to ProfileActivity
            startActivity(intent);
            return true;
        }
        return false;
    }
}
