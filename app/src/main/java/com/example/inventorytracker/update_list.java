package com.example.inventorytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.NonWritableChannelException;

public class update_list extends AppCompatActivity
{
    DatabaseHelper myDb;
    EditText pname,price,quantity,sname,scontact;
    Button btnupdate;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb = new DatabaseHelper(this);

        pname = findViewById(R.id.pname);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        sname = findViewById(R.id.sname);
        scontact = findViewById(R.id.scontact);
        btnupdate = findViewById(R.id.btnupdate);
        updateData();

    }

    public void updateData(){
        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb.updateData(pname.getText().toString(), price.getText().toString(), quantity.getText().toString(),
                                sname.getText().toString(), scontact.getText().toString());
                        if(isUpdate == true)
                        {
                            Toast.makeText(update_list.this,"Data Updated",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(update_list.this,"Data Not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}