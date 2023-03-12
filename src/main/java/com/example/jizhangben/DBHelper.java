package com.example.jizhangben;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {   //搭建数据库
    private static int DB_VERSION = 1;
    private static String DB_Name = "account_daily.db";

    public DBHelper(Context context){
        super(context,DB_Name,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table account(_id integer primary key autoincrement," +//主键
                "Title varchar(20)," +//Title
                "Date varchar(20)," +//Date
                "Money vaechar(20))";//Money
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
