package com.example.hamishstewart.foodtracker.Models;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class Food {
    private int id;
    private MealType meal;

    public Food(int id, MealType meal) {
        this.id = id;
        this.meal = meal;
    }

    public MealType getMealType() {
        return this.meal;
    }
}
