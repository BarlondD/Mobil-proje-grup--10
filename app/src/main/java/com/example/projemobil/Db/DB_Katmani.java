package com.example.projemobil.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Katmani extends SQLiteOpenHelper {

    public DB_Katmani(Context c){
        super(c, "MobilProjje",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SCORE (ISIM VARCHAR(20), SURE INTEGER) ";
        db.execSQL(sql);
        sql= "CREATE TABLE LEVELS (LV2 INTEGER, LV3 INTEGER , LV4 INTEGER, LV5 INTEGER) ";
        db.execSQL(sql);
        sql="INSERT INTO LEVELS VALUES ('0','0','0','0')";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
public boolean insertSCORE(String isim , int sure){
    SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
    cv.put("ISIM", isim);
    cv.put("SURE",sure);
    db.insert("SCORE", null ,cv);
    return  true;

}

public Cursor getAllData(){
    SQLiteDatabase db=this.getWritableDatabase();
    Cursor res = db.rawQuery("SELECT * FROM SCORE ORDER BY SURE", null);
    return res;
}




}

