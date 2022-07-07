package com.gsy.storage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @author gsuiy
 * @create 2022-07-07 19:12
 */
public class MyDataBase extends SQLiteOpenHelper {
    private Context mContext;

    public static final String CREATE_EMPLOYEE = "create table enmployee(" +
            "id integer primary key autoincrement," +//主键自增长 id 整形 int  integer
            "name varchar," +  //名字：文本类型 text char varCher
            "salary double," + // 资金 ：浮点类型 double float
            "birthday date)" ; //生日：date dateTime 日期类型


    public MyDataBase(@Nullable Context context) {//创建数据库
        super(context, "data.db", null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建数据表
        db.execSQL(CREATE_EMPLOYEE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
