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

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.nav_profile);



        bottomNavigation.setOnItemReselectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Intent intent;
        if(item.getItemId() == R.id.nav_home){ // Navigate to HomeActivity
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_notifications){ // Navigate to NotificationActivity
            intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_statistics){ // Navigate to StatisticsActivity
            intent = new Intent(this, StatisticsActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_tasks){ // Navigate to TasksActivitys
            intent = new Intent(this, TasksActivitys.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_profile){ // Navigate to ProfileActivity
            return true;
        }
        return false;
    }
}
