package com.example.hamishstewart.foodtracker.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hamishstewart.foodtracker.R;

import java.util.ArrayList;

/**
 * Created by hamishstewart on 21/11/2017.
 */

public class FoodListAdapter extends ArrayAdapter<Food> {
    public FoodListAdapter(Context context, ArrayList<Food> food) {
        super(context, 0, food);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.food_item, parent, false);
        }

        Food currentFoodItem = getItem(position);

        TextView type = listItemView.findViewById(R.id.Type);
        type.setText(currentFoodItem.getMealType().getMeal());

        TextView eaten = listItemView.findViewById(R.id.Eaten);
        eaten.setText(currentFoodItem.getEaten().toString());

        TextView date = listItemView.findViewById(R.id.Date);
        date.setText((currentFoodItem.getDate().toString()));

        TextView calories = listItemView.findViewById(R.id.Calories);
        date.setText((currentFoodItem.getDate().toString()));

        listItemView.setTag(currentFoodItem);

        return listItemView;
    }

}
