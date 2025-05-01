package com.example.app_dev_final_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class databaseConnection extends SQLiteOpenHelper {

    private static final String databaseName = "KeepItUp_db";
    private static final String databaseTable = "Users";
    private static int dbVersion = 1;
    private static final String ID = "id";
    private static final String Fullname = "fullname";
    private static final String Phonenumber = "phonenumbers";
    private static final String Username = "username";
    private static final String Password = "password";

    public databaseConnection(@Nullable Context context) {
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + databaseTable + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Fullname + " TEXT, "
                + Phonenumber + " TEXT, "
                + Username + " TEXT, "
                + Password + " TEXT)";
        Log.d("Database", "Creating table: " + query);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + databaseTable);
        onCreate(db);
    }

    // method for add users
    public void addUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Fullname, users.getFullname());
        values.put(Phonenumber, users.getPhonenumbers());
        values.put(Username, users.getUsername());
        values.put(Password, users.getPassword());
        Log.d("Database", "Inserting user: " + users.getFullname() + ", " + users.getUsername());
        long result = db.insert(databaseTable, null, values);
        if (result == -1) {
            Log.d("Database", "Error inserting data");
            System.out.print("Database Error ");
        } else {
            Log.d("Database", "User inserted successfully with ID: " + result);
            System.out.print("Success ");
        }
        db.close();
    }

    // method to check login credentials and return full name
    public String checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String fullName = null;
        String query = "SELECT " + Fullname + " FROM " + databaseTable + " WHERE " + Username + " = ? AND " + Password + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        if (cursor.moveToFirst()) {
            fullName = cursor.getString(cursor.getColumnIndexOrThrow(Fullname));
        }
        cursor.close();
        db.close();
        return fullName; // Returns full name if login successful, null otherwise
    }
}