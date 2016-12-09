package com.example.a309.ssgwajes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
/**
 * Created by 302 on 2016-12-09.
 */
public class DB extends SQLiteOpenHelper {
    public DB (Context context, String touch, CursorFactory factory, int version) {
        super(context,touch,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //새로운 테이블 생성
        //create table 테이블명 (컬럼명 타입 옵션)
    db.execSQL("CREATE TABLE Touch(_id INTEGER PRIMARY KEY AUTOINCREMENT, Touch TEXT, price INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
    }
}
