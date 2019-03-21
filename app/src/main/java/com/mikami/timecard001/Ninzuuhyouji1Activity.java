package com.mikami.timecard001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Ninzuuhyouji1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninzuuhyouji1);

        Button ninzuuhyouji2 = findViewById(R.id.ninzuuhyouji2);
        ninzuuhyouji2.setOnClickListener(new Ninzuuhyouji2ButtonListener());
    }
}
