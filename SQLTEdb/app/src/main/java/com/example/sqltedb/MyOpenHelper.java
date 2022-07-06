package com.example.sqltedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {
    public static String DB_NAME="sai";
    public static String DB_TABLE="students";
//    public static int COL_0=0;
    public static String COL_1="name";
    public static String COL_2="rollnum";
   public static String QUERY="create table if not exists "+DB_TABLE+"("+COL_1+" text,"+COL_2+" text primary key);";
//String QUERY = "create table if not exists student(id integer primary key autoincrement,name varchar(100),mobile varchar(10));";
    public MyOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DB_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long saveData(ContentValues cn){
        SQLiteDatabase db=getWritableDatabase();
        long row=db.insert(DB_TABLE,null,cn);
        return row;

    }
    public Cursor retriveData(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+DB_TABLE,null);
        return c;
    }

}
