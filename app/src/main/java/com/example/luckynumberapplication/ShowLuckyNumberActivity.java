package com.example.luckynumberapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ShowLuckyNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lucky_number);

        String userName = getIntent().getStringExtra("userName");
        int luckyNumber = new Random().nextInt(1000);

        TextView userNameTextView = findViewById(R.id.textViewUserName);
        userNameTextView.setText(String.format("Hello, %s", userName));

        TextView luckyNumberTextView = findViewById(R.id.textViewLuckyNumber);
        luckyNumberTextView.setText(String.format("Your lucky number: %s", luckyNumber));

        findViewById(R.id.buttonShare)
                .setOnClickListener(v -> {
                    Intent shareLucyNumberIntent = new Intent(Intent.ACTION_SEND);
                    shareLucyNumberIntent.setType("text/plain");

                    shareLucyNumberIntent.putExtra(
                            Intent.EXTRA_SUBJECT, String.format("Lucky number for %s", userName)
                    );
                    shareLucyNumberIntent.putExtra(
                            Intent.EXTRA_TEXT, String.format("Hi! I would share mu lucky number: %s", luckyNumber)
                    );

                    startActivity(shareLucyNumberIntent);
                });
    }
}