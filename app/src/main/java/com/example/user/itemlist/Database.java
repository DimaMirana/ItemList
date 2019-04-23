package com.example.user.itemlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 4/5/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Product.db";
    public static final String TABLE_NAME="Chemicals";
    public static final String TABLE_NAME2="Glass";
    public static final String TABLE_NAME3="Plastic";
    public static final String TABLE_NAME4="Others";
    public static final String Col_1="item_id";
    public static final String Col_2="item_name";
    public static final String Col_3="origin";
    public static final String Col_4="std_pkg";
    public static final String Col_5="quantity";
    public static final String Col_6="unit_price";
    public static final String Col_7="total_price";
    public static final String Col_8="sell_date";

    public Database(Context context)  {
        super(context,DATABASE_NAME,null,1);
        //SQLiteDatabase database=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL ("create table " + TABLE_NAME +"(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Col_2 + " TEXT," + Col_3 +" TEXT," + Col_4 + " TEXT,"
                + Col_5 + " INTEGER," + Col_6 + " INTEGER," + Col_7 + " INTEGER,"
                + Col_8 + " Text" + ") ");
        db.execSQL ("create table " + TABLE_NAME2 +"(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Col_2 + " TEXT," + Col_3 +" TEXT," + Col_4 + " TEXT,"
                + Col_5 + " INTEGER," + Col_6 + " INTEGER," + Col_7 + " INTEGER,"
                + Col_8 + " Text" + ") ");
        db.execSQL ("create table " + TABLE_NAME3 +"(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Col_2 + " TEXT," + Col_3 +" TEXT," + Col_4 + " TEXT,"
                + Col_5 + " INTEGER," + Col_6 + " INTEGER," + Col_7 + " INTEGER,"
                + Col_8 + " Text" + ") ");
        db.execSQL ("create table " + TABLE_NAME4 +"(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Col_2 + " TEXT," + Col_3 +" TEXT," + Col_4 + " TEXT,"
                + Col_5 + " INTEGER," + Col_6 + " INTEGER," + Col_7 + " INTEGER,"
                + Col_8 + " Text" + ") ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME );
        onCreate(db);
    }
    boolean insert_data(String item_name,String origin,String std_pkg,Integer quantity,Integer unit_price,Integer total_price,String date )
    {
        SQLiteDatabase database = this.getWritableDatabase();

        String insert = "insert into Chemicals(item_name,origin,std_pkg,quantity,unit_price,total_price,sell_date) " +
                "values('"+item_name+"','"+origin+"','"+std_pkg+"'," +
                "'"+quantity+"','"+unit_price+"','"+total_price+"','"+date+"')";
        database.execSQL(insert);

        database.close();

        return true;
    }
    public List<info> getAllChemicals()
    {
        List<info> chemical=new ArrayList<info>();
        SQLiteDatabase db=this.getReadableDatabase();

        String selectquery="SELECT * FROM "+ TABLE_NAME ;
        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
               info chemicals= new info(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),Integer.parseInt(cursor.getString(4)),Integer.parseInt(cursor.getString(5)));
                chemicals.setId(Integer.parseInt(cursor.getString(0)));
                chemicals.setName(cursor.getString(1));
                chemicals.setOrigin(cursor.getString(2));
                chemicals.setPkg(cursor.getString(3));
                chemicals.setQuantity(Integer.parseInt(cursor.getString(4)));
                chemicals.setUnit_price(Integer.parseInt(cursor.getString(5)));
                //chemicals.setTotal_price(Integer.parseInt(cursor.getString(6)));
               // chemicals.setDate(cursor.getString(7));

                chemical.add( chemicals);
            }while(cursor.moveToNext());
        }
        db.close();
        return  chemical;
    }
    public void deleteAll()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();

    }
    public info getChemicalDetails(String chemicals)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        //String selectquery="select * from AddBook where Book_Name="+book;
        //Cursor cursor=db.rawQuery(selectquery, null);

        Cursor cursor = db.query(TABLE_NAME, new String[] {Col_1,Col_2,Col_3,Col_4,Col_5,Col_6,Col_7,Col_8}, Col_2+"=?",new String[]{chemicals} ,null, null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        info info= new info(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                Integer.parseInt(cursor.getString(4)),Integer.parseInt(cursor.getString(5)),Integer.parseInt(cursor.getString(6)),cursor.getString(7));
        info.setId(Integer.parseInt(cursor.getString(0)));
        info.setName(cursor.getString(1));
        info.setOrigin(cursor.getString(2));
        info.setPkg(cursor.getString(3));
        info.setQuantity(Integer.parseInt(cursor.getString(4)));
        info.setUnit_price(Integer.parseInt(cursor.getString(5)));
        info.setTotal_price(Integer.parseInt(cursor.getString(6)));
        info.setDate(cursor.getString(7));



        db.close();

        return info;
    }
    public boolean updateData(String name,Integer quantity,Integer total_price,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, name);
        contentValues.put(Col_5, quantity);
        contentValues.put(Col_7, total_price);
        contentValues.put(Col_8, date);
        db.update(TABLE_NAME, contentValues, "item_name = ?",new  String[] { name });
        return true;
    }

}
