package com.example.digitalnum;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "userdb1";
    private static final String TABLE_Users = "userdetails";

    private static final String KEY_NAME = "username";
    private static final String KEY_AGE = "userage";
    private static final String KEY_ADDR = "useraddr";
    private static final String KEY_CITY = "usercity";
    private static final String KEY_MOBILE = "usermobile";
    private static final String KEY_CARD = "Card_number";

    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "(" + KEY_NAME + " TEXT,"
                + KEY_AGE + " TEXT,"
                + KEY_ADDR + " TEXT"+ "," + KEY_CITY + " TEXT," + KEY_MOBILE + " TEXT,"+ KEY_CARD + " TEXT"+")";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);

        onCreate(db);
    }

    void insertUserDetails(String username,String userage,String useraddr,String usercity,String usermobile,String Card_number){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, username);
        cValues.put(KEY_AGE, userage);
        cValues.put(KEY_ADDR, useraddr);
        cValues.put(KEY_CITY, usercity);
        cValues.put(KEY_MOBILE, usermobile);
        cValues.put(KEY_CARD, Card_number);

        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
    }

    public Cursor getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * FROM " + TABLE_Users + " WHERE " +KEY_MOBILE+ "='"+id+"'" ,null);
        return cursor;
    }
}