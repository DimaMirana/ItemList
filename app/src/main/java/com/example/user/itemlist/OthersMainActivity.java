package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OthersMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_main);
    }
    public void View_others(View view){

        Intent intent = new Intent(this,ViewOtherActivity.class);
        startActivity(intent);
    }

    public void Sell_others(View view){

        Intent intent = new Intent(this,SellOtherActivity.class);
        startActivity(intent);
    }

    public void Add_others(View view){

        Intent intent = new Intent(this,AddOtherActivity.class);
        startActivity(intent);
    }
}
