package com.example.hamishstewart.foodtracker.Controllers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hamishstewart.foodtracker.Db.FoodTrackerDatabase;
import com.example.hamishstewart.foodtracker.Models.Food;
import com.example.hamishstewart.foodtracker.Models.MealType;
import com.example.hamishstewart.foodtracker.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EditActivity extends AppCompatActivity {
    private TextView eMealtype, eFoodEaten, eDateEaten;
    private EditText updateMeal, updateFood, updateDate;
    private Button saveUpdateButton;
    private Button deleteButton;
    private String foodID;
    Spinner editMealDropdown;
    FoodTrackerDatabase myDb;
    Calendar myCalendar = Calendar.getInstance();

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
        foodID = String.valueOf(food.getId());
        String mealType = food.getMealType().getMeal();

        for(int i = 0; i < items.length; i++) {
            if(items[i].equals(mealType)) {
                this.editMealDropdown.setSelection(i);
                break;
            }
        }
            //the above for loop will loop through items array
            //if the item equals my saved food meal type
            //then that id is the id of the selection which
            //will be used to populate the correct item on the spinner

    }

//    public void onSaveUpdateButtonClicked(View button) {
//        String meal = (String) this.editMealDropdown.getSelectedItem();
//        String food = this.updateFood.getText().toString();
//        String date = this.updateDate.getText().toString();
//
//        myDb.updateData(foodID, MealType.convertToMealType(meal), food, date, calories);
//        finish();
//    }


    public void onDeleteButtonClicked(View button) {
        myDb.deleteData(foodID);
        finish();
    }

    DatePickerDialog.OnDateSetListener
            date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updatelabel();
        }
    };

    public void updatelabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.UK);
        updateDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void onDateClicked(View editText) {
        new DatePickerDialog(EditActivity.this, date,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}
