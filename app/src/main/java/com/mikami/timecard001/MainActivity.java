package com.mikami.timecard001;

import android.app.AutomaticZenRule;
import android.app.admin.DeviceAdminInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button syukkinnButton;
    private Button taikinnButton;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        super.onResume();

        DatabaseHelper helper = new DatabaseHelper(MainActivity.this);

        boolean isTaikinToday = helper.isTaikinToday();
        if (isTaikinToday) {
            this.syukkinnButton.setEnabled(false);
            this.taikinnButton.setEnabled(false);
            return;
        }

        boolean isShukkinToday = helper.isShukkinToday();
        if (isShukkinToday) {
            this.syukkinnButton.setEnabled(false);
            this.taikinnButton.setEnabled(true);
        } else {
            this.taikinnButton.setEnabled(true);
            this.syukkinnButton.setEnabled(false);
        }
    }
}

