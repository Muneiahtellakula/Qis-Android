package com.example.sqlitedbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    String Query = "create table if not exists student(id integer primary key autoincrement,name varchar(100),mobile varchar(10));";

    public DbHelper(@Nullable Context context) {
        super(context, "QisDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table student");
        onCreate(sqLiteDatabase);
    }

    public long insertData(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        long i = db.insert("student",null,values);
        return i;
    }

    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select *from student",null);
        return c;
    }

}
