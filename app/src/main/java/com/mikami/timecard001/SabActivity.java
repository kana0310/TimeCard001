package com.mikami.timecard001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sab);

        Intent intent = getIntent();

        TextView monthAndDayTextView = findViewById(R.id.monthAndDayTextView);
        String monthAndDay = intent.getStringExtra("monthAndDay");
        monthAndDayTextView.setText(monthAndDay);

        TextView hourAndMinuteTextView = findViewById(R.id.hourAndMinuteTextView);
        String hourAndMinute = intent.getStringExtra("hourAndMinute");
        hourAndMinuteTextView.setText(hourAndMinute);

        TextView statusTextView = findViewById(R.id.statusTextView);
        String statusText = intent.getStringExtra("statusText");
        statusTextView.setText(statusText);

        Button returnButton = findViewById(R.id.returnbutton);
        returnButton.setOnClickListener(new ReturnButtonListener(this));

    }

    public void onBackButtonListener(View view) {
        finish();
    }
}