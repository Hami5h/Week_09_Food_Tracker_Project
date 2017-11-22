package com.example.hamishstewart.foodtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hamishstewart.foodtracker.Db.FoodTrackerDatabase;
import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.MealType;
import com.example.hamishstewart.foodtracker.R;

public class EditActivity extends AppCompatActivity {
    private TextView eMealtype, eFoodEaten, eDateEaten;
    private EditText updateMeal, updateFood, updateDate;
    private Button saveUpdateButton;
    private Button deleteButton;
    Spinner editMealDropdown;
    FoodTrackerDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        myDb = new FoodTrackerDatabase(this);
        saveUpdateButton = (Button) findViewById(R.id.saveUpdateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        this.eMealtype = (TextView) findViewById(R.id.eMealtype);
        this.eFoodEaten = (TextView)findViewById(R.id.eFoodEaten);
        this.eDateEaten = (TextView) findViewById(R.id.eDateEaten);
        this.updateFood = (EditText) findViewById(R.id.updateFood);
        this.updateDate = (EditText) findViewById(R.id.updateDate);

        this.editMealDropdown = findViewById(R.id.updateMealSpinner);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snack"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        editMealDropdown.setAdapter(adapter);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Food food = (Food) extras.getSerializable("Food");

        this.updateFood.setText(food.getEaten());
        this.updateDate.setText(food.getDate());

        this.editMealDropdown.setSelection(0);

    }

    public void onSaveUpdateButtonClicked(View button) {
        String meal = (String) this.editMealDropdown.getSelectedItem();
        String food = this.updateFood.getText().toString();
        String date = this.updateDate.getText().toString();

        myDb.updateData(MealType.convertToMealType(meal), food, date);
        finish();
    }

    public void onDeleteButtonClicked(View button) {
        String meal = (String) this.editMealDropdown.getSelectedItem();
        String food = this.updateFood.getText().toString();
        String date = this.updateDate.getText().toString();

        myDb.deleteData();
        finish();
    }


}
