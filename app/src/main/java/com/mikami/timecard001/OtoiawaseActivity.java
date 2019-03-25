package com.mikami.timecard001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class OtoiawaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otoiawase);

        Button kyannserubutton = findViewById(R.id.kyannserubutton);
        kyannserubutton.setOnClickListener(new KyannseruButtonClickListener(this));
    }
}
