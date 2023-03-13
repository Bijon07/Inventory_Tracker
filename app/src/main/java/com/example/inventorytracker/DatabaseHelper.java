package com.example.inventorytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String Database_Name = "Inventory.db";
    public static final String Table_Name = "Product_List";
    public static final String Col_1 = "NAME";
    public static final String Col_2 = "PRICE";
    public static final String Col_3 = "QUANTITY";
    public static final String Col_4 = "SUPPLIER_NAME";
    public static final String Col_5 = "SUPPLIER_CONTACT";

    public DatabaseHelper(Context context)
    {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(" create table " + Table_Name + " (name text PRIMARY KEY , price text, quantity text, supplier_name text, supplier_contact text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(" DROP TABLE if exists " + Table_Name);
        onCreate(db);
    }

    public boolean insertData(String name, String price, String quantity, String supplier_name, String supplier_contact)
    {
        SQLiteDatabase db = this.getWritableDatabase(); //ch
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,name);
        contentValues.put(Col_2,price);
        contentValues.put(Col_3,quantity);
        contentValues.put(Col_4,supplier_name);
        contentValues.put(Col_5,supplier_contact);
        long result= db.insert(Table_Name,null,contentValues);

        if(result == -1)
            return false;
        else
            return  true;
    }

    public boolean updateData(String name, String price, String quantity,String supplier_name, String supplier_contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,name);
        contentValues.put(Col_2,price);
        contentValues.put(Col_3,quantity);
        contentValues.put(Col_4,supplier_name);
        contentValues.put(Col_5,supplier_contact);
        db.update(Table_Name, contentValues,"Name = ?",new String[]{name}); //update
        return true;
    }
}
