package com.example.user.itemlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddChemicalActivity extends Activity {

    Database database;
    EditText editName,editOrigin,editPkg,editQuantity,editUnitPrice;
    Button addbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chemical);
        database=new Database(this);
        editName=(EditText)findViewById(R.id.editText6);
        editOrigin=(EditText)findViewById(R.id.editText7);
        editPkg=(EditText)findViewById(R.id.editText8);
        editQuantity=(EditText)findViewById(R.id.editText9);
        editUnitPrice=(EditText)findViewById(R.id.editText10);
        addbutton=(Button)findViewById(R.id.button20);

        insert_chemicals();

    }
    public void insert_chemicals()
    {

        addbutton.setOnClickListener(

                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        final int val = Integer.parseInt( editQuantity.getText().toString() );
                        final int val2 = Integer.parseInt( editUnitPrice.getText().toString() );
                        final String date ="not sold yet";
                        final int val4=val*val2;




                        if(editName.getText().toString().isEmpty()||editOrigin.getText().toString().isEmpty()||
                                editPkg.getText().toString().isEmpty()||editQuantity.getText().toString().isEmpty()||editUnitPrice.getText().toString().isEmpty())
                        {
                            Toast.makeText(AddChemicalActivity.this, "Some Fields Are Empty", Toast.LENGTH_LONG).show();

                        }

                        else
                        {
                            boolean isInserted = database.insert_data(editName.getText().toString(),
                                    editOrigin.getText().toString(),editPkg.getText().toString(),
                                   val,val2,val4,date);


                            if (isInserted = true)
                            {
                                Toast.makeText(AddChemicalActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                editName.setText(null);
                                editOrigin.setText(null);
                                editPkg.setText(null);
                                editQuantity.setText(null);
                                editUnitPrice.setText(null);


                            }
                        }
                        //database.insert_data(bi);


                    }
                }
        );





    }

}

