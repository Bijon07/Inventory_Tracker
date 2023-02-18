package com.example.inventorytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener
{
    private CardView item, update,delete,sell,search,view;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //define cards
        item = (CardView) findViewById(R.id.item_List);
        update = (CardView) findViewById(R.id.update_Item);
        delete = (CardView) findViewById(R.id.delete_Item);
        sell= (CardView) findViewById(R.id.sell_List);
        search = (CardView) findViewById(R.id.search_Item);
        view = (CardView) findViewById(R.id.view_Albam);

        //Add clickListener to the cards
        item.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        sell.setOnClickListener(this);
        search.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent i;

        switch (view.getId())
        {
            case R.id.item_List:i = new Intent(this,item_list.class); startActivity(i); break;
            case R.id.update_Item:i= new Intent(this,update_list.class); startActivity(i); break;
            case R.id.delete_Item:i = new Intent(this,delete_item.class); startActivity(i); break;
            case R.id.sell_List:i = new Intent(this,sell_item.class); startActivity(i); break;
            case R.id.search_Item:i = new Intent(this,search_item.class); startActivity(i); break;
            case R.id.view_Albam:i = new Intent(this,view_item.class); startActivity(i); break;
            default:break;
        }
    }
}