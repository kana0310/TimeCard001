package com.mikami.timecard001;

public final class SQL {

        public static final String DDL = "CREATE TABLE timecard (_id INTEGER, year INTEGER, month INTEGER, day INTEGER, start_hour INTEGER, start_minute INTEGER, end_hour INTEGER, end_minute INTEGER)";
        public static final String SHUKKIN = "INSERT INTO timecard (year, month, day, start_hour, start_minute) VALUES (?, ?, ?, ?, ?)";
        public static final String TAIKIN = "UPDATE timecard SET end_hour = ?, end_minute = ? WHERE year = ? AND month =? AND day = ?";
        public static final String SELECT = "SELECT * FROM timecard WHERE month = ? AND year = ? ORDER BY day DESC";
        public static final String COUNT_SHUKKIN_TODAY = "SELECT COUNT(*) AS cnt FROM timecard WHERE year = ? AND month = ? AND day = ?";
        public static final String COUNT_TODAY_WORKED = "SELECT COUNT(*) AS cnt FROM timecard WHERE year = ? AND month = ? AND day = ? AND start_hour IS NOT NULL AND end_hour IS NOT NULL";
        public static final String DELETE_ALL = "DELETE from timecard";

}
