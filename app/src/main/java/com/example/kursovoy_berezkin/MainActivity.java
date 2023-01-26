package com.example.kursovoy_berezkin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.kursovoy_berezkin.fragments.HomeFragment;
import com.example.kursovoy_berezkin.fragments.RoutinesFragment;
import com.example.kursovoy_berezkin.fragments.SettingsFragment;
import com.example.kursovoy_berezkin.fragments.StaticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    StaticsFragment staticsFragment = new StaticsFragment();
    RoutinesFragment routinesFragment = new RoutinesFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.statics:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,staticsFragment).commit();
                        return true;
                    case R.id.routines:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,routinesFragment).commit();
                        return true;
                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    public void AddRoom(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this, AddRoomActivity.class);
        startActivity(intent);
    }

}