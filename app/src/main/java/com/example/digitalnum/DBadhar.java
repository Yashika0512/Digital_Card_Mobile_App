package com.example.digitalnum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBadhar extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Aadhar";
    private static final String TABLE_ADHAR = "aadhartab";
    private static final String KEY_CID = "cid";
    private static final String KEY_NAME = "name";
    private static final String KEY_ANO = "adharnum";
    private static final String KEY_GEN = "gender";
    private static final String KEY_ADDR = "addr";
    private static final String KEY_PIN = "pincode";
    private static final String KEY_PHN = "phone";

    public DBadhar(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ADHAR + "("
                + KEY_CID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT,"
                + KEY_ANO + " INTEGER,"
                + KEY_GEN + " TEXT" + "," + KEY_ADDR + " TEXT," + KEY_PIN + " INTEGER," + KEY_PHN + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADHAR);

        onCreate(db);
    }


    void insertAdharDetails(String cid, String name, String adharnum, String gender, String addr, String pincode, String phn) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_CID, cid);
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_ANO, adharnum);
        cValues.put(KEY_GEN, gender);
        cValues.put(KEY_ADDR, addr);
        cValues.put(KEY_PIN, pincode);
        cValues.put(KEY_PHN, phn);


        long newRowId = db.insert(TABLE_ADHAR, null, cValues);
        db.close();
    }
    public Cursor getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * FROM " + TABLE_ADHAR + " WHERE " +KEY_CID+ "='"+id+"'" ,null);
        return cursor;
    }
}
