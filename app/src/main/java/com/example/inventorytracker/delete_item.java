package com.example.inventorytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_item extends AppCompatActivity {
    Button delete;
    EditText pname;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteitem);
        delete = findViewById(R.id.delete);
        pname = findViewById(R.id.pname);
        db = new DatabaseHelper(this);
        deleteData();
    }
    public void deleteData(){
        delete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean deleted = db.deleteData(pname.getText().toString());
                        if(deleted){
                            Toast.makeText(delete_item.this,"Data deleted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(delete_item.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}