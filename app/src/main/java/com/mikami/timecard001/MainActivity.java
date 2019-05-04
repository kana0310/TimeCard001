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

        Button taikinnButton = findViewById(R.id.taikinnbutton);
        taikinnButton.setOnClickListener(new TaikinnButtonListener());

        Button otoiawaseButton = findViewById(R.id.otoiawsebutton);
        otoiawaseButton.setOnClickListener(new OtoiawaseButtonListener());

        Button ninzuuhyouzi = findViewById(R.id.ninzuuhyoujibutton);
        ninzuuhyouzi.setOnClickListener(new NinzuuhyoujiButtonListener());

        Button syousaihyouzi = findViewById(R.id.hyouzibutton);
        syousaihyouzi.setOnClickListener(new HyouziButtonListener());
    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHelper helper = new DBHelper(MainActivity.this);


        boolean isWorkFinished = helper.isWorkFinished();
        if (isWorkFinished) {
            Button syukkinnButton.setEnabled(false);
            Button tainkinnButton.setEnabled(false);
            return;
        }

        boolean isAlreadyShukkinToday = helper.isAlreadyShukkinToday();
        if (isAlreadyShukkinToday) {

            Button syukkinButton.setEnabled(false);
            Button taikinButton.setEnabled(true);
        } else {

            Button syukkinButton.setEnabled(true);
            Button taikinButton.setEnabled(false);
        }
    }
}
}
