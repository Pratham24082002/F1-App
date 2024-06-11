package com.example.f1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.nav_drivers) {
                    selectedFragment = new DriverStandingsFragment();
                } else if (item.getItemId() == R.id.nav_constructors) {
                    selectedFragment = new ConstructorStandingsFragment();
                } else if (item.getItemId() == R.id.nav_races) {
                    selectedFragment = new RacesFragment();
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                }

                return true;
            }
        });

        // Default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DriverStandingsFragment()).commit();
        }
    }
}
