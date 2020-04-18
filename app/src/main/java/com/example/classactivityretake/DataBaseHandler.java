package com.example.classactivityretake;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;

    private static final String DATABASE_NAME="studentsInfo.db";


    SQLiteDatabase database;

    public DataBaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        database=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table students_emails_table (id integer primary key autoincrement,name text,email text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS students_emails_table");
        onCreate(db);

    }
    public String saveData(String n1, String d1){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",d1);
        cv.put("name",n1);

        long res=db.insert("students_emails_table",null,cv);

            if(res==-1)
                return "Fail";
            else
                return "saved successfully";
    }
}
