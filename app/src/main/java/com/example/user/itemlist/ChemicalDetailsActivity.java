package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class ChemicalDetailsActivity extends AppCompatActivity {
    Database db;
    TextView cId,cName,cPkg,cOrigin,cQuantity,cUnit,cTotal,cDate;
    Button sell;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_details);
        cId = (TextView) findViewById(R.id.item_id);
        cName = (TextView) findViewById(R.id.cName);
        cOrigin = (TextView) findViewById(R.id.cOrigin);
        cPkg = (TextView) findViewById(R.id.cPkg);
        cQuantity = (TextView) findViewById(R.id.cQuantity);
        cUnit = (TextView) findViewById(R.id.cUnit);
        cTotal = (TextView) findViewById(R.id.cTotal);
        cDate = (TextView) findViewById(R.id.cDate);
        sell = (Button) findViewById(R.id.sell);

        Intent intent = getIntent();
        db = new Database(this);
        Bundle bundle = intent.getExtras();

        String cNames = bundle.getString("cName");
        info info = db.getChemicalDetails(cNames);

        int id = info.getId();
        name = info.getName();
        String origin = info.getOrigin();
        String pkg = info.getPkg();
        Integer quantity = info.getQuantity();
        Integer unit_price = info.getUnit_price();
        Integer total_price = info.getTotal_price();
        String date = info.getDate();
        cId.setText(String.valueOf(id));
        cName.setText(name);
        cOrigin.setText(origin);
        cPkg.setText(pkg);
        cQuantity.setText(String.valueOf(quantity));
        cUnit.setText(String.valueOf(unit_price));
        cTotal.setText(String.valueOf(total_price));
        cDate.setText(date);
        sell();
    }
        public void sell() {
            sell.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ChemicalDetailsActivity.this, SellChemicalActivity.class);

                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                }
        );

        }

    }


