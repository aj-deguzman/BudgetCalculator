package com.deguzman.budgetcalculator;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    //declare variables
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data.db";
    public static final String TABLE_DATA = "data";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATANAME = "dataname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //onCreate place our query in String
        //adds unique id and name columns
        String query = "CREATE TABLE " + TABLE_DATA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                + COLUMN_DATANAME + " TEXT "
                + ");";
        //execute our query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete table if it already exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_DATA);
        onCreate(db);
    }

    //add new row to db
    public void addData(Data data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATANAME, data.get_dataName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DATA, null, values);
        db.close();
    }

    //delete data from db
    public void deleteData(String dataname) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_DATA + " WHERE " + COLUMN_DATANAME + "=\"" + dataname);
    }
}
