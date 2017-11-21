package com.example.hamishstewart.foodtracker.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodTracker.db";
    public static final String TABLE_NAME = "FOOD";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_MEAL_TYPE = "MealType";
    public static final String COLUMN_FOOD_EATEN = "FoodEaten";
    public static final String COLUMN_DATE = "DATE";

    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MEAL_TYPE + " VARCHAR, "
                + COLUMN_FOOD_EATEN + " VARCHAR, "
                + COLUMN_DATE + " TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(MealType meal, String eaten, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_FOOD_EATEN, eaten);
        contentValues.put(COLUMN_DATE, date);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void updateData(String id, MealType meal, String eaten, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_FOOD_EATEN, eaten);
        contentValues.put(COLUMN_DATE, date);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",new String[] {id});
        db.close();
    }
}
