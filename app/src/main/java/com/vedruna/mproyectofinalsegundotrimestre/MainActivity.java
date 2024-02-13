package com.vedruna.mproyectofinalsegundotrimestre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        bottomNavigationView.setOnItemSelectedListener(item -> {

                    if (item.getItemId() == R.id.navigation_home) {
                        navController.navigate(R.id.homeFragment);
                    } else if (item.getItemId() == R.id.navigation_crear){
                        navController.navigate(R.id.crearFragment);
                    } else if (item.getItemId() == R.id.navigation_modificar){
                        navController.navigate(R.id.modificarFragment);
                    } else if (item.getItemId() == R.id.navigation_borrar){
                        navController.navigate(R.id.borrarFragment);
                    } else if (item.getItemId() == R.id.navigation_salir){
                        navController.navigate(R.id.salirFragment);
                    }
                    return true;
                }

        );

    }
}