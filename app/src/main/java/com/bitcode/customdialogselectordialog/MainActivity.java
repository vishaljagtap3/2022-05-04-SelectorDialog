package com.bitcode.customdialogselectordialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnShowSelectorDialog, btnShowSelectorDialogForSkills;
    private TextView txtFavCities;

    private String [] cities = {
      "Pune", "Mumbai", "Chennai", "Bengaluru", "Nagpur"
    };
    private String [] skills = {
            "C", "C++", "Core Java", "Kotlin", "Android", "Swift", "Python"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setUpListeners();
    }

    private void setUpListeners() {
        btnShowSelectorDialog.setOnClickListener(new BtnShowSelectorDialogClickListener());
        btnShowSelectorDialogForSkills.setOnClickListener(
                new BtnShowSelectorDialogForSkillsClickListener()
        );
    }

    private class BtnShowSelectorDialogForSkillsClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SelectorDialog selectorDialog = new SelectorDialog(
                    MainActivity.this,
                    skills
            );
            selectorDialog.setTitle("IT Skills");
            selectorDialog.setOnOptionsSetListener(new MyOnSkillsOptionsSelectedListener());
            selectorDialog.show();
        }
    }

    private class BtnShowSelectorDialogClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SelectorDialog selectorDialog =
                    new SelectorDialog(
                            MainActivity.this,
                            cities
                    );
            selectorDialog.setTitle("Fav Cities");
            selectorDialog.setOnOptionsSetListener(new MyOnCitiesOptionsSelectedListener());
            selectorDialog.show();
        }
    }

    private void initViews() {
        btnShowSelectorDialog = findViewById(R.id.btnShowSelectorDialog);
        txtFavCities = findViewById(R.id.txtFavCities);
        btnShowSelectorDialogForSkills = findViewById(R.id.btnShowSelectorDialogForSkills);
    }

    private class MyOnCitiesOptionsSelectedListener implements SelectorDialog.OnOptionsSetListener {
        @Override
        public void onOptionsSet(ArrayList<String> selectedCities) {

            txtFavCities.setText("");

            for(String city : selectedCities) {
                txtFavCities.append(city + "\n");
            }
        }
    }

    private class MyOnSkillsOptionsSelectedListener implements SelectorDialog.OnOptionsSetListener {
        @Override
        public void onOptionsSet(ArrayList<String> selectedSkills) {
            txtFavCities.setText("");

            for(String skill : selectedSkills) {
                txtFavCities.append(skill + "\n");
            }
        }
    }
}