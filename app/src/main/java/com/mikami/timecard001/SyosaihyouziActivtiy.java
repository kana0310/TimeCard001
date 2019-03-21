package com.mikami.timecard001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SyosaihyouziActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syosaihyouzi);

        Intent intent = getIntent();

        TableRow tableLayout = findViewById(R.id.tableRow1);


    }
}
