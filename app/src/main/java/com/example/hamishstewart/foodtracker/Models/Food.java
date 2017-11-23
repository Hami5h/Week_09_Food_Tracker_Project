package com.example.hamishstewart.foodtracker.Models;

import java.io.Serializable;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class Food implements Serializable {
    private int id;
    private MealType meal;
    private String eaten;
    private String date;
    private String calories;


    public Food(Integer id, MealType meal, String eaten, String date, String calories) {
        this.id = id;
        this.meal = meal;
        this.eaten = eaten;
        this.date = date;
        this.calories = calories;
    }

    public int getId() {
        return this.id;
    }

    public MealType getMealType() {
        return this.meal;
    }

    public String getEaten() {
        return this.eaten;
    }

    public String getDate() {
        return this.date;
    }

    public String getCalories() {
        return this.calories;
    }

    public void setMealType(MealType meal) {
        this.meal = meal;
    }

    public void setEaten(String eaten) {
        this.eaten = eaten;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }


}
