package com.example.hamishstewart.foodtracker.Models;

import java.util.ArrayList;

/**
 * Created by hamishstewart on 21/11/2017.
 */

public class FoodList {
     ArrayList<Food> list;

     public FoodList() {
         list = new ArrayList<Food>();
         list.add(new Food(1, MealType.BREAKFAST, "Cornflakes", "20/11/2017"));
         list.add(new Food(2, MealType.LUNCH, "Caesar Salad", "20/11/2017"));
         list.add(new Food(3, MealType.DINNER, "Stovies", "20/11/2017"));
         list.add(new Food(4, MealType.SNACK, "Crisps", "20/11/2017"));
     }

    public ArrayList<Food> getList() {
        return new ArrayList<Food>(list);
    }
}
