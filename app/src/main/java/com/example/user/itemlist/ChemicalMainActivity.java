package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChemicalMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_main);
    }
    public void View_Chemical(View view){

        Intent intent = new Intent(ChemicalMainActivity.this,ViewChemicalActivity.class);
        startActivity(intent);
    }

    public void Sell_Chemical(View view){

        Intent intent = new Intent(ChemicalMainActivity.this,SellChemicalActivity.class);
        startActivity(intent);
    }

    public void Add_Chemical(View view){

        Intent intent = new Intent(ChemicalMainActivity.this,AddChemicalActivity.class);
        startActivity(intent);
    }

}
