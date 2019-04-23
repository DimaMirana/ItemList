package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlasticMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic_main);
    }
    public void View_plastic(View view){

        Intent intent = new Intent(this,ViewPlasticActivity.class);
        startActivity(intent);
    }

    public void Sell_plastic(View view){

        Intent intent = new Intent(this,SellPlasticActivity.class);
        startActivity(intent);
    }

    public void Add_plastic(View view){

        Intent intent = new Intent(this,AddPlasticActivity.class);
        startActivity(intent);
    }
}
