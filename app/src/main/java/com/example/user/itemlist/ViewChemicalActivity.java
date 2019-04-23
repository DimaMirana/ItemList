package com.example.user.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewChemicalActivity extends AppCompatActivity {
    Database db;
    List<info>chemicals;
    ArrayAdapter<String> adapter;
    EditText filterText;
    ArrayList<String> list;
    ListView listView,listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chemical);
        listView=(ListView)findViewById(R.id.chemical_list);
        listView2=(ListView)findViewById(R.id.origin8);
        db=new Database(this);
        chemicals=db.getAllChemicals();
        final String string[]=new String[chemicals.size()];
        int i=0;
        for(info chemi : chemicals)
        {
            string[i]=new String(chemi.getName());
            //Log.d("list book",string[i]);
            i++;
        }
        adapter=new ArrayAdapter<String>(this,R.layout.row_design,string);
        listView.setAdapter(adapter);


        filterText=(EditText)findViewById(R.id.editChemical);
        filterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                ViewChemicalActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewChemicalActivity.this,ChemicalDetailsActivity.class);
                String cName=adapter.getItem(position);
                intent.putExtra("cName",cName);
                startActivity(intent);


            }
        });
    }
}
