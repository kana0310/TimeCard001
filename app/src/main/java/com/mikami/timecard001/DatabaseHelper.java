package com.mikami.timecard001;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "syukkinnbo.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE syukkinnbo(");
        sb.append("_id INTEGER PRIMARY KEY,");
        sb.append("year INTEGER,");
        sb.append("month INTEGER,");
        sb.append("day INTEGER,");
        sb.append("start_hour INTEGER,");
        sb.append("start_minute INTEGER,");
        sb.append("end_hour INTEGER,");
        sb.append("end_minute INTEGER )");
        String sql = sb.toString();

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isShukkinToday() {
        SQLiteDatabase db = this.getReadableDatabase();
        LocalDate today = LocalDate.now();
        try {
            String nowYear = String.valueOf(today.getYear());
            String nowMonth = String.valueOf(today.getMonthValue());
            String nowDay = String.valueOf(today.getDayOfMonth());
            String sql = "SELECT COUNT(*) AS cnt FROM syukkinbo WHERE year = ? AND month = ? AND day = ?";
            Cursor cursor = db.rawQuery(sql, new String[]{nowYear, nowMonth, nowDay});
            cursor.moveToNext();
            int index = cursor.getColumnIndex("cnt");
            int count = cursor.getInt(index);
            return count != 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.close();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isTaikinToday() {
        SQLiteDatabase db = this.getReadableDatabase();
        LocalDate today = LocalDate.now();
        try {
            String nowYear = String.valueOf(today.getYear());
            String nowMonth = String.valueOf(today.getMonthValue());
            String nowDay = String.valueOf(today.getDayOfMonth());
            String sql = "SELECT COUNT(*) AS cnt FROM sykkinbo WHERE year = ? AND month = ? AND day = ? AND start_hour IS NOT NULL AND end_hour IS NOT NULL";
            Cursor cursor = db.rawQuery(sql, new String[]{nowYear, nowMonth, nowDay});
            cursor.moveToNext();
            int index = cursor.getColumnIndex("cnt");
            int count = cursor.getInt(index);
            return count != 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.close();
        }

    }
}


