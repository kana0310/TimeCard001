package com.mikami.timecard001;

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
public class TaikinnButtonListener implements View.OnClickListener {

    private Button taikinnButton;

    @Override
    public void onClick(View view) {
        LocalDateTime now = LocalDateTime.now();
        //Toast.makeText(view.getContext(),now.toString(),Toast.LENGTH_LONG).show();

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String monthAndDay = month + "月" + day + "日";

        int hour = now.getHour();
        int minute = now.getMinute();
        String hourAndMinute = hour + "時" + minute + "分";

        String statusText = "退勤しました。";

        Intent intent = new Intent(view.getContext(), SabActivity.class);
        intent.putExtra("monthAndDay", monthAndDay);
        intent.putExtra("hourAndMinute", hourAndMinute);
        intent.putExtra("statusText", statusText);


        view.getContext().startActivity(intent);

        DatabaseHelper helper = new DatabaseHelper(view.getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            String sqlUpdate = "UPDATE syukkinnbo SET end_hour = ? , end_minute = ? WHERE year = ? AND month = ? AND day = ?";
            SQLiteStatement stmt = db.compileStatement(sqlUpdate);

            stmt.bindLong(1, hour);
            stmt.bindLong(2, minute);
            stmt.bindLong(3, year);
            stmt.bindLong(4, month);
            stmt.bindLong(5, day);

            stmt.executeUpdateDelete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

    }
}
