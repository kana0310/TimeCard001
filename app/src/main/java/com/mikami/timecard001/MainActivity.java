package com.mikami.timecard001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button syukkinButton = findViewById(R.id.syukkinbotton);
        syukkinButton.setOnClickListener(new SyukkinButtonListener());

        Button taikinnbutton = findViewById(R.id.taikinnbutton);
        taikinnbutton.setOnClickListener(new TaikinnButtonListener());

        Button otoiawasebutton = findViewById(R.id.otoiawsebutton);
        otoiawasebutton.setOnClickListener(new OtoiawaseButtonListener());

        Button ninzuuhyouzi = findViewById(R.id.ninzuuhyoujibutton);
        ninzuuhyouzi.setOnClickListener(new NinzuuhyoujiButtonListener());

        Button syousaihyouzi = findViewById(R.id.hyouzibutton);
        syousaihyouzi.setOnClickListener(new HyouziButtonListener());
    }
}
