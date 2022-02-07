package com.example.digitalnum;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBlicense extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "License";
    private static final String TABLE_LICENSE = "licensetab";
    private static final String KEY_CID = "cid";
    private static final String KEY_NAME = "name";
    private static final String KEY_LNO = "license";
    private static final String KEY_VALID = "valid";
    private static final String KEY_ADDR = "addr";
    private static final String KEY_PIN = "pincode";
    private static final String KEY_PHN = "phone";

    public DBlicense(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_LICENSE + "("
                + KEY_CID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT,"
                + KEY_LNO + " INTEGER,"
                + KEY_VALID + " INTEGER" + "," + KEY_ADDR + " TEXT," + KEY_PIN + " INTEGER," + KEY_PHN + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LICENSE);

        onCreate(db);
    }



    void insertAdharDetails(String cid, String name, String license, String valid, String addr, String pincode, String phn) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_CID, cid);
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_LNO, license);
        cValues.put(KEY_VALID, valid);
        cValues.put(KEY_ADDR, addr);
        cValues.put(KEY_PIN, pincode);
        cValues.put(KEY_PHN, phn);


        long newRowId = db.insert(TABLE_LICENSE, null, cValues);
        db.close();
    }
    public Cursor getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * FROM " + TABLE_LICENSE + " WHERE " +KEY_CID+ "='"+id+"'" ,null);
        return cursor;
    }
}

