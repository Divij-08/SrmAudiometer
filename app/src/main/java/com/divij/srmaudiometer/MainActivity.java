package com.divij.srmaudiometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner mspinner = findViewById(R.id.spinner);
        List<Integer>list = new ArrayList<>();
        TextView mheading =findViewById(R.id.Heading);
        TextView mName =findViewById(R.id.name);
        TextView mage =findViewById(R.id.age);
        TextView mgender =findViewById(R.id.gender);
        EditText mInputName=findViewById(R.id.Input_name);
        RadioGroup mRadiogrp = findViewById(R.id.sex);
        RadioButton mMale = findViewById(R.id.male);
        RadioButton mFemale = findViewById(R.id.female);

        for(int i=1;i<=100;i++)
        {
            list.add(i);
        }


        ArrayAdapter<Integer>arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(arrayAdapter);

        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}