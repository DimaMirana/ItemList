package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class GlasswareMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glassware_main);
    }
    public void View_Glassware(View view){

        Intent intent = new Intent(this,ViewGlassActivity.class);
        startActivity(intent);
    }

    public void Sell_Glassware(View view){

        Intent intent = new Intent(this,SellGlassActivity.class);
        startActivity(intent);
    }

    public void Add_Glassware(View view){

        Intent intent = new Intent(this,AddGlassActivity.class);
        startActivity(intent);
    }
}
