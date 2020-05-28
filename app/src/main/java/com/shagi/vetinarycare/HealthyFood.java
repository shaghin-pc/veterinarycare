package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class HealthyFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences;
        String save,typ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_food);

        sharedPreferences=getSharedPreferences("PET",MODE_PRIVATE);
        save=sharedPreferences.getString("type",null);

        Toast.makeText(getApplicationContext(),save,Toast.LENGTH_LONG).show();
    }
}
