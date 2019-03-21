package com.mikami.timecard001;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SinnpuruhyouziActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinnpuruhyouzi_activtiy);
        ListView itirannList = findViewById(R.id.itirannList);
        List<String> timeCradList = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(SinnpuruhyouziActivtiy.this);
        SQLiteDatabase db = helper.getReadableDatabase();
        try {
            String sqlSelect = "SELECT * FROM syukkinnbo";
            Cursor cursor = db.rawQuery(sqlSelect, null);

            while (cursor.moveToNext()) {
                int index = cursor.getColumnIndex("year");
                int year = cursor.getInt(index);
                index = cursor.getColumnIndex("month");
                int month = cursor.getInt(index);
                index = cursor.getColumnIndex("day");
                int day = cursor.getInt(index);
                index = cursor.getColumnIndex("start_hour");
                int start_hour = cursor.getInt(index);
                index = cursor.getColumnIndex("start_minute");
                int start_minute = cursor.getInt(index);
                index = cursor.getColumnIndex("end_hour");
                int end_hour = cursor.getInt(index);
                index = cursor.getColumnIndex("end_minute");
                int end_minute = cursor.getInt(index);


                String line = year + "年" + month + "月" + day + "日" + start_hour + "時" + start_minute + "分"
                        +end_hour+"時"+end_minute+"分";
                timeCradList.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }
        //timeCradList.add("2019年3月21日10時00分");
        //timeCradList.add("2019年3月22日10時00分");
//コメント
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SinnpuruhyouziActivtiy.this,
                android.R.layout.simple_list_item_1,timeCradList);
        itirannList.setAdapter(adapter);
    }
}
