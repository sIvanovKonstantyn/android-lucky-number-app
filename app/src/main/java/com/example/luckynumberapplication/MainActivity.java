package com.example.luckynumberapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText personName = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.buttonShow)
                .setOnClickListener(v -> {
                    Intent showLucyNumberIntent = new Intent(
                            getApplicationContext(),
                            ShowLuckyNumberActivity.class
                    );

                    showLucyNumberIntent.putExtra("userName", personName.getText().toString());
                    startActivity(showLucyNumberIntent);
                });

    }
}