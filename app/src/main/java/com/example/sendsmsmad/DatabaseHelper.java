package com.example.sendsmsmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static android.provider.BaseColumns._ID;

public class DatabaseHelper extends SQLiteOpenHelper {

//    public static final String DATABSE_NAME="student.db";
//    public static final String TABLE_NAME="student_table";
//    public static final String COL1="ID";
//    public static final String COL2="NUMBER";
//    public static final String COL3="MESSAGE";
    private static final String DATABASE_NAME = "callz.db";
    private static final int DATABASE_VERSION = 1;




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String sql ="CREATE TABLE USERMASSAGE(id INTEGER PRIMARY KEY AUTOINCREMENT,USERNUMBER TEXT ,MESSAGEDETAILS TEXT,STATUSZ TEXT)";
        sqLiteDatabase.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertdata(String messagenumber,String messagedetails,SQLiteDatabase database){
        ContentValues values = new ContentValues();
        values.put("USERNUMBER",messagenumber);
        values.put("MESSAGEDETAILS",messagedetails);
        values.put("STATUSZ","Sent");
        database.insert("USERMASSAGE",null,values);

    }

    public void deletedata(String messageid,SQLiteDatabase database){

        String deleteque ="DELETE FROM USERMASSAGE WHERE id='"+messageid+"'";
        database.execSQL(deleteque);

    }
}
