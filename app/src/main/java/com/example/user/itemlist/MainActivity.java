package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Chemical_Main(View view){

        Intent intent = new Intent(MainActivity.this,ChemicalMainActivity.class);
        startActivity(intent);
    }

    public void Glassware_Main(View view){

        Intent intent = new Intent(MainActivity.this,GlasswareMainActivity.class);
        startActivity(intent);
    }

    public void PlasticMain(View view){

        Intent intent = new Intent(MainActivity.this,PlasticMainActivity.class);
        startActivity(intent);
    }

    public void Other_Main(View view){

        Intent intent = new Intent(MainActivity.this,OthersMainActivity.class);
        startActivity(intent);
    }
}
