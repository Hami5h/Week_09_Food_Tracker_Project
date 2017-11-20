package com.example.hamishstewart.foodtracker.Models;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class Food {
    private int id;
    private MealType meal;
    private String date;


    public Food(int id, MealType meal, String date) {
        this.id = id;
        this.meal = meal;
        this.date = date;
    }

    public MealType getMealType() {
        return this.meal;
    }

    public int getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public void setMealType(MealType meal) {
        this.meal = meal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
