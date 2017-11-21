package com.example.hamishstewart.foodtracker.Models;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class Food {
    private int id;
    private MealType meal;
    private String eaten;
    private String date;


    public Food(int id, MealType meal, String eaten, String date) {
        this.id = id;
        this.meal = meal;
        this.eaten = eaten;
        this.date = date;
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


}
