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
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.nav_home); // Set default selected item
        // Use method reference instead of lambda
        bottomNavigation.setOnItemSelectedListener(this::onNavigationItemSelected);

        // Retrieve the full name from the intent login
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("FULL_NAME");

        // Split the full name to get the first name
        String firstName = fullName.split(" ")[0];
        // Find the TextView and set the full name
        TextView headerNameText = findViewById(R.id.headerName_text);
        headerNameText.setText(firstName);
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
