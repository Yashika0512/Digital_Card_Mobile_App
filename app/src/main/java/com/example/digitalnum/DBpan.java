package com.example.digitalnum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBpan extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "PanDb";
    private static final String TABLE_PAN = "pantab";
    private static final String KEY_CID = "cid";
    private static final String KEY_NAME = "name";
    private static final String KEY_PNO = "pannum";

    private static final String KEY_ADDR = "addr";
    private static final String KEY_PIN = "pincode";
    private static final String KEY_PHN = "phone";

    public DBpan(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PAN + "("
                + KEY_CID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT,"
                + KEY_PNO + " INTEGER," + KEY_ADDR + " TEXT," + KEY_PIN + " INTEGER," + KEY_PHN + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAN);

        onCreate(db);
    }

    void insertPanDetails(String cid, String name, String pannum, String addr, String pincode, String phn) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_CID, cid);
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_PNO, pannum);

        cValues.put(KEY_ADDR, addr);
        cValues.put(KEY_PIN, pincode);
        cValues.put(KEY_PHN, phn);


        long newRowId = db.insert(TABLE_PAN, null, cValues);
        db.close();
    }
    public Cursor getData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * FROM " + TABLE_PAN + " WHERE " +KEY_CID+ "='"+id+"'" ,null);
        return cursor;
    }
}

