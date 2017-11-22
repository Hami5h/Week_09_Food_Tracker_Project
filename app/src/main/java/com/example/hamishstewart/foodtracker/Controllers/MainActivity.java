package com.example.hamishstewart.foodtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.hamishstewart.foodtracker.Db.FoodTrackerDatabase;
import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.FoodListAdapter;
import com.example.hamishstewart.foodtracker.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  FoodTrackerDatabase myDb;
  Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new FoodTrackerDatabase(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Food> food = myDb.getAllRecords();

        FoodListAdapter foodAdapter = new FoodListAdapter(this, food);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(foodAdapter);
    }

    public void onClickFoodType(View textView) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);

    }

    public void onAddButtonClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);

        startActivity(intent);
    }




}
