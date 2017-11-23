package com.example.hamishstewart.foodtracker.Controllers;

import android.app.DatePickerDialog;
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
import com.example.hamishstewart.foodtracker.Models.MealType;
import com.example.hamishstewart.foodtracker.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {
    private TextView mealType, foodEaten, dateEaten, caloriesEaten;
    private EditText editFood, editDate, editCalories;
    private Button saveButton;
    FoodTrackerDatabase myDb;
    Spinner mealTypeDropdown;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        myDb = new FoodTrackerDatabase(this);

        this.mealTypeDropdown = (Spinner) findViewById(R.id.mealTypeSpinner);
        String[] items = new String[]{"Breakfast", "Lunch", "Dinner", "Snack"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mealTypeDropdown.setAdapter(adapter);

        this.mealType = (TextView) findViewById(R.id.MealType);
        this.foodEaten = (TextView)findViewById(R.id.foodEaten);
        this.dateEaten = (TextView) findViewById(R.id.dateEaten);
        this.caloriesEaten = (TextView) findViewById(R.id.caloriesEaten);
        this.editFood = (EditText) findViewById(R.id.editFood);
        this.editDate = (EditText) findViewById(R.id.editDate);
        this.editCalories= (EditText) findViewById(R.id.editCalories);
    }

    public void onSaveButtonClicked(View button) {
        String meal = (String) this.mealTypeDropdown.getSelectedItem();
        String food = this.editFood.getText().toString();
        String date = this.editDate.getText().toString();
        String calories = this.editCalories.getText().toString();

        myDb.insertData(MealType.convertToMealType(meal), food, date, calories);
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
        editDate.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void onDateClicked(View editText) {
                new DatePickerDialog(AddActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


}
