package com.mikami.timecard001;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SyukkinButtonListener implements View.OnClickListener {

    private Button syukkinButton;

    @Override
    public void onClick(View v) {
//        SyukkinButton.setEnabled(false);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SyukkinButton.setEnabled(true);
//            }
//        },10000L);
        LocalDateTime now = LocalDateTime.now();
        // Toast.makeText(v.getContext(), "現在時刻:" + now, Toast.LENGTH_LONG).show();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String monthAndDay = month + "月" + day + "日";

        int hour = now.getHour();
        int minute = now.getMinute();
        String hourAndMinute = hour + "時" + minute + "分";

        String statusText = "出勤しました。";


        Intent intent = new Intent(v.getContext(), SabActivity.class);
        intent.putExtra("monthAndDay", monthAndDay);
        intent.putExtra("hourAndMinute", hourAndMinute);
        intent.putExtra("statusText", statusText);


        v.getContext().startActivity(intent);

        DatabaseHelper helper = new DatabaseHelper(v.getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            String sqlInsert = "INSERT INTO syukkinnbo(year,month,day,start_hour,start_minute)VALUES(?,?,?,?,?)";
            SQLiteStatement stmt = db.compileStatement(sqlInsert);

            //stmt.bindLong(1, _id);
            stmt.bindLong(1, year);
            stmt.bindLong(2, month);
            stmt.bindLong(3, day);
            stmt.bindLong(4, hour);
            stmt.bindLong(5, minute);

            stmt.executeInsert();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

    }

}
