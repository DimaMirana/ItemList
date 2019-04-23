package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SellChemicalActivity extends AppCompatActivity {
    Database db;
    EditText quantity,date;
    Button ok;
    Integer previous_quantity,previous_total,unit_price;
    String item_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_chemical);
        quantity = (EditText) findViewById(R.id.q);
        date = (EditText) findViewById(R.id.date);
        ok = (Button) findViewById(R.id.ok);

        Intent intent = getIntent();
        db = new Database(this);
        Bundle bundle = intent.getExtras();

        String name = bundle.getString("name");
        info info = db.getChemicalDetails(name);


        item_name = info.getName();
         previous_quantity = info.getQuantity();
        previous_total = info.getTotal_price();
         unit_price = info.getUnit_price();
        update();



    }


        public void update()
    {
        ok.setOnClickListener(
                new View.OnClickListener()
                {

                    @Override
                    public void onClick(View v) {
                        int edit_quantity = Integer.parseInt(quantity.getText().toString());

                        final int uQuantity = previous_quantity - edit_quantity;
                        final int uTotal = previous_total - (edit_quantity * unit_price);
                        final String uDate = date.getText().toString();

                        boolean updated = db.updateData(item_name, uQuantity, uTotal, uDate);
                        if (updated == true) {
                            Toast.makeText(SellChemicalActivity.this, "Data updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }














}
