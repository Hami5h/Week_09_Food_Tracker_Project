package com.example.hamishstewart.foodtracker.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hamishstewart.foodtracker.R;

public class WelcomeActivity extends AppCompatActivity {
    private ImageButton iLoveFoodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        this.iLoveFoodButton = (ImageButton) findViewById(R.id.imageButton);
    }

    public void onILoveFoddButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
