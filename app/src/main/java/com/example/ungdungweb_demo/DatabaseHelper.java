package com.example.ungdungweb_demo;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "Account_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ACCOUNT = "Account";
    private static final String NAME_COLUMN = "name";
    private static final String EMAIL_COLUMN = "email";
    private static final String PHONE_COLUMN = "phone";
    private static final String PASS_COLUMN = "pass";
    private static final String BIRTHDATE_COLUMN = "birthdate";
    private static final String CREATE_WORD_TABLE_SQL = "CREATE TABLE " + TABLE_ACCOUNT + " (" +
            NAME_COLUMN + " TEXT," +
            EMAIL_COLUMN + " TEXT NOT NULL," +
            PHONE_COLUMN + " TEXT NOT NULL," +
            PASS_COLUMN + " TEXT NOT NULL," +
            BIRTHDATE_COLUMN + " TEXT," +
            "PRIMARY KEY "+"("+ EMAIL_COLUMN + "," + PHONE_COLUMN +")" +
            ")";

    private static DatabaseHelper sInstance;

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e(TAG, "DatabaseHelper: ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate: ");
        db.execSQL(CREATE_WORD_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade: ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        onCreate(db);
    }

    public boolean insertAccount(UserInfor account) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(NAME_COLUMN,"HU HU");
        values.put(EMAIL_COLUMN, account.getEmail());
        values.put(PHONE_COLUMN, account.getPhone());
        values.put(PASS_COLUMN, account.getPassword());
        //values.put(BIRTHDATE_COLUMN, "10/10/10");
        long rowId = db.insert(TABLE_ACCOUNT, null, values);
        db.close();
        if (rowId != -1)
            return true;
        return false;
    }



    public List<UserInfor> getAllUserInfor() {
        SQLiteDatabase db = getReadableDatabase();
        List<UserInfor> words = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_ACCOUNT;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                words.add(new UserInfor(cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return words;
    }

    public int getTotalUserInfor() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_ACCOUNT;
        Cursor cursor = db.rawQuery(sql, null);
        int totalRows = cursor.getCount();
        cursor.close();
        return totalRows;
    }
}