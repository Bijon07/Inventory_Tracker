package com.example.inventorytracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view_item extends AppCompatActivity {
    DatabaseHelper myDb;
    //Button btnViewItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);
        myDb = new DatabaseHelper(this);

        //btnViewItem = findViewById(R.id.view_Albam);
        viewItem();
    }

    public void viewItem()
    {

        Cursor cursor = myDb.viewData();
        if(cursor.getCount() == 0)
        {
            showMessage("ERROR!", "NO DATA FOUND");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext())
        {
            buffer.append("Product Name: "+cursor.getString(0)+"\n");
            buffer.append("Product Price: "+cursor.getString(1)+"\n");
            buffer.append("Product Quantity: "+cursor.getString(2)+"\n");
            buffer.append("Supplier Name: "+cursor.getString(3)+"\n");
            buffer.append("Supplier Contact: "+cursor.getString(4)+"\n\n\n");
        }

        showMessage("PRODUCT INFORMATION", buffer.toString());
    }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}