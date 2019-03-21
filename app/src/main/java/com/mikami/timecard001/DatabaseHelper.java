package com.mikami.timecard001;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

}
