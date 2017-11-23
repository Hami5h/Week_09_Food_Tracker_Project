package com.example.hamishstewart.foodtracker.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.MealType;

import java.util.ArrayList;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class FoodTrackerDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "FoodTracker.db";
    public static final String TABLE_NAME = "FOOD";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_MEAL_TYPE = "MealType";
    public static final String COLUMN_FOOD_EATEN = "FoodEaten";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_CALORIES = "Calories";

    public FoodTrackerDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MEAL_TYPE + " VARCHAR, "
                + COLUMN_FOOD_EATEN + " VARCHAR, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_CALORIES + " VARCHAR );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(MealType meal, String eaten, String date, String calories) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_FOOD_EATEN, eaten);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_CALORIES, calories);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void updateData(String id, MealType meal, String eaten, String date, String calories) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEAL_TYPE, meal.getMeal());
        contentValues.put(COLUMN_FOOD_EATEN, eaten);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_CALORIES, calories);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",new String[] {id});
        db.close();
    }

    public ArrayList<Food> getAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Food> foods = new ArrayList<Food>();
        Food food;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);

                String meal = cursor.getString(1);
                MealType mealType = MealType.convertToMealType(meal);

                String eaten = cursor.getString(2);
                String date = cursor.getString(3);
                String calories = cursor.getString(4);

                food = new Food(id, mealType, eaten, date, calories );
                foods.add(food);
            }
        }
        cursor.close();
        db.close();
        return foods;
    }
}
