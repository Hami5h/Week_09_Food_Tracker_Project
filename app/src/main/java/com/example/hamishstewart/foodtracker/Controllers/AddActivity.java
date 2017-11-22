package com.example.hamishstewart.foodtracker.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hamishstewart.foodtracker.Db.FoodTrackerDatabase;
import com.example.hamishstewart.foodtracker.Models.MealType;
import com.example.hamishstewart.foodtracker.R;

public class AddActivity extends AppCompatActivity {
    private TextView mealtype, foodEaten, dateEaten;
    private EditText editMeal, editFood, editDate;
    private Button saveButton;
    FoodTrackerDatabase myDb;
    Spinner mealTypeDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        myDb = new FoodTrackerDatabase(this);

        this.mealTypeDropdown = (Spinner) findViewById(R.id.mealTypeSpinner);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snack"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mealTypeDropdown.setAdapter(adapter);

        this.mealtype = (TextView) findViewById(R.id.Mealtype);
        this.foodEaten = (TextView)findViewById(R.id.foodEaten);
        this.dateEaten = (TextView) findViewById(R.id.dateEaten);
        this.editFood = (EditText) findViewById(R.id.editFood);
        this.editDate = (EditText) findViewById(R.id.editDate);

    }

    public void onSaveButtonClicked(View button) {
        String meal = (String) this.mealTypeDropdown.getSelectedItem();
        String food = this.editFood.getText().toString();
        String date = this.editDate.getText().toString();

        myDb.insertData(MealType.convertToMealType(meal), food, date);
        finish();
    }


}
