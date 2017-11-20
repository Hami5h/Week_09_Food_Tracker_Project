package com.example.hamishstewart.foodtracker;

import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.MealType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class FoodTest {

    Food food;

    @Test
    public void canGetMealType() {
        food = new Food(1, MealType.BREAKFAST);
        assertEquals(MealType.BREAKFAST, food.getMealType());
    }
}
