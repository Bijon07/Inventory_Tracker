package com.example.inventorytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class item_list extends AppCompatActivity
{
    DatabaseHelper myDb;
    EditText pname,price,quantity,sname,scontact;
    Button btnadd;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);
        myDb= new DatabaseHelper(this);

        pname = findViewById(R.id.pname);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        sname = findViewById(R.id.sname);
        scontact = findViewById(R.id.scontact);
        btnadd = findViewById(R.id.btnadd);
        addData();

    }

    public void addData(){
        btnadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(pname.getText().toString(), price.getText().toString(),quantity.getText().toString(), sname.getText().toString(),
                                scontact.getText().toString());
                        if(isInserted){
                            Toast.makeText(item_list.this,"Data inserted",Toast.LENGTH_LONG).show();
                            pname.setText("");
                            price.setText("");
                            quantity.setText("");
                            sname.setText("");
                            scontact.setText("");
                        }
                        else
                        {
                            Toast.makeText(item_list.this,"Data not inserted",Toast.LENGTH_LONG).show();
                            pname.setText("");
                            price.setText("");
                            quantity.setText("");
                            sname.setText("");
                            scontact.setText("");
                        }

                    }
                }
        );
    }
}