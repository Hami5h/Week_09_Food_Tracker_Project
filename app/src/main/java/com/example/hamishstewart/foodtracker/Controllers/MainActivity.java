package com.example.hamishstewart.foodtracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hamishstewart.foodtracker.Db.FoodTrackerDatabase;
import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.FoodList;
import com.example.hamishstewart.foodtracker.Models.FoodListAdapter;
import com.example.hamishstewart.foodtracker.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  FoodTrackerDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new FoodTrackerDatabase(this);

        FoodList foodList = new FoodList();
        ArrayList<Food> food = foodList.getList();

        FoodListAdapter foodAdapter = new FoodListAdapter(this, food);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(foodAdapter);
    }

    public void getFood(View listItemSelected) {
        Food selectedFood = (Food) listItemSelected.getTag();

//        Toast.makeText(this,
//                selectedFood.getMealType(),
//                Toast.LENGTH_SHORT).show();

    }


}
