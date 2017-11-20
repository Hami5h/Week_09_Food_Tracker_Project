package com.example.hamishstewart.foodtracker;

import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.MealType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by hamishstewart on 20/11/2017.
 */

public class FoodTest {

    Food food;

    @Before
    public void before() {
        food = new Food(1, MealType.BREAKFAST, "20/11/2017");
    }

    @Test
    public void canGetMealType() {
        assertEquals(MealType.BREAKFAST, food.getMealType());
    }

    @Test
    public void canGetId() {
        assertEquals(1, food.getId());
    }

    @Test
    public void canGetDate() {
        assertEquals("20/11/2017", food.getDate());
    }


}
