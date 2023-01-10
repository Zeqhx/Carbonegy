package com.example.carbonegy2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    // Database version and name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myapp.db";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE users (id INTEGER PRIMARY KEY, email TEXT, password TEXT)";
        db.execSQL(createUsersTable);

        String createEmissionsGoalTable = "CREATE TABLE emissions_goal (user_id INTEGER PRIMARY KEY, goal INTEGER)";
        db.execSQL(createEmissionsGoalTable);

        String createEmissionsTable = "CREATE TABLE emissions (id INTEGER PRIMARY KEY, user_id INTEGER, date TEXT, value INTEGER)";
        db.execSQL(createEmissionsTable);

        String createMonthlyEmissionsTable = "CREATE TABLE monthly_emissions (id INTEGER PRIMARY KEY, user_id INTEGER, month INTEGER, year INTEGER, value INTEGER)";
        db.execSQL(createMonthlyEmissionsTable);

        String createEmissionsPercentageTable = "CREATE TABLE emissions_percentage (id INTEGER PRIMARY KEY, user_id INTEGER, month INTEGER, year INTEGER, value REAL)";
        db.execSQL(createEmissionsPercentageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Modify the database schema as needed here
        // using SQL ALTER TABLE and ALTER COLUMN statements
    }

    public boolean isValidUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{"id"}, "email = ? and password = ?", new String[]{email, password}, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
    public boolean addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        long result = db.insert("users", null, values);
        return result != -1;
    }

}


