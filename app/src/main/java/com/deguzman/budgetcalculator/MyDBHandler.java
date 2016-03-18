package com.deguzman.budgetcalculator;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    //declare variables
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "budget.db";
    public static final String TABLE_BUDGET = "budget";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_BUDGETSUMMARY = "budgetName";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //onCreate place our query in String
        //adds unique id and name columns
        String query = "CREATE TABLE " + TABLE_BUDGET + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                + COLUMN_BUDGETSUMMARY + " TEXT "
                + ");";
        //execute our query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete table if it already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUDGET);
        onCreate(db);
    }

    //add new row to db
    public void addBudgetData(Budgets budget) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BUDGETSUMMARY, budget.get_budgetName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_BUDGET, null, values);
        db.close();
    }

    //delete data from db
    public void deleteBudgetData(String budgetName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_BUDGET
                + " WHERE " + COLUMN_BUDGETSUMMARY + "=\"" + budgetName + "\";");
    }

    //print db as String
    public String dbToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + "WHERE 1";

        //Cursor to point to first row
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        //make sure pointer is not at last row
        //then loop through rows and print rows
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("budgetName")) != null) {
                dbString += c.getString(c.getColumnIndex("budgetName"));
                dbString += "\n";
            }
        }

        db.close();
        return dbString;
    }
}
