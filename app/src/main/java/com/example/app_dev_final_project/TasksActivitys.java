package com.example.app_dev_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TasksActivitys extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_tasks);

        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigateItemSelected);
    }

    private boolean onNavigateItemSelected(MenuItem item) {
        Intent intent;

        if(item.getItemId() == R.id.nav_home){ // navigate to HomeActivity
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_notifications){ // navigate to NotificationActivity
            intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_statistics){ // navigate to StatisticsActivity
            intent = new Intent(this, StatisticsActivity.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == R.id.nav_tasks){
            // stay on TaskActivity
            return true;
        }
        else if(item.getItemId() == R.id.nav_profile){ // navigate to ProfileActivity
            intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
