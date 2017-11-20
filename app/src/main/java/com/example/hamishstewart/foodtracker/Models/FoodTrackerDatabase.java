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
    public static final String COLUMN_BREAKFAST = MealType.BREAKFAST.name();
    public static final String COLUMN_LUNCH = MealType.LUNCH.name();
    public static final String COLUMN_DINNER = MealType.DINNER.name();
    public static final String COLUMN_SNACK = MealType.SNACK.name();
    public static final String COLUMN_DATE = "DATE";

    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_BREAKFAST + " VARCHAR, "
                + COLUMN_LUNCH + " VARCHAR, "
                + COLUMN_DINNER + " VARCHAR, "
                + COLUMN_SNACK + " VARCHAR, "
                + COLUMN_DATE + " VARCHAR );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(MealType meal, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BREAKFAST, MealType.BREAKFAST.name());
        contentValues.put(COLUMN_LUNCH, MealType.LUNCH.name());
        contentValues.put(COLUMN_DINNER, MealType.DINNER.name());
        contentValues.put(COLUMN_SNACK, MealType.SNACK.name());
        contentValues.put(COLUMN_DATE, date );
        db.insert(TABLE_NAME, null, contentValues);
    }
}
