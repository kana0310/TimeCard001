package com.mikami.timecard001;

import android.app.AutomaticZenRule;
import android.app.admin.DeviceAdminInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button syukkinButton;
    private Button taikinnButton;
    private Button otoiawaseButton;
    private Button ninzuuhyouzi;
    private Button syousaihyouzi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.syukkinButton = findViewById(R.id.syukkinbotton);
        syukkinButton.setOnClickListener(new SyukkinButtonListener());

        this.taikinnButton = findViewById(R.id.taikinnbutton);
        taikinnButton.setOnClickListener(new TaikinnButtonListener());

        this.otoiawaseButton = findViewById(R.id.otoiawsebutton);
        otoiawaseButton.setOnClickListener(new OtoiawaseButtonListener());

        this.ninzuuhyouzi = findViewById(R.id.ninzuuhyoujibutton);
        ninzuuhyouzi.setOnClickListener(new NinzuuhyoujiButtonListener());

        this.syousaihyouzi = findViewById(R.id.hyouzibutton);
        syousaihyouzi.setOnClickListener(new HyouziButtonListener());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onResume(){
        super.onResume();

        DatabaseHelper helper = new DatabaseHelper(MainActivity.this);

        boolean isSyukkin = helper.isShukkinToday();
        if(isSyukkin){
            syukkinButton.setEnabled(false);
            taikinnButton.setEnabled(true);
        }else{
            syukkinButton.setEnabled(true);
            taikinnButton.setEnabled(false);
        }

        boolean isTaikinn = helper.isTaikinToday();
        if(isTaikinn){
            syukkinButton.setEnabled(false);
            taikinnButton.setEnabled(false);
            return;
        }


    }

}

