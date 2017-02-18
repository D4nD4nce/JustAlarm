package com.alarmproject.dandance.justalarm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLiteOpenHelper extends SQLiteOpenHelper {

    private String strCreateTable;
    private String strTableName;

    DBSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                       int version)
    {
        super(context, name, factory, version);
        strTableName = name;
    }

    //создаем и заполняем БД
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // создание таблиц
        db.execSQL(strCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists " + strTableName);
        this.onCreate(db);
    }

    void setStrCreateTable(String strCreateTable) {
        this.strCreateTable = strCreateTable;
    }

    void setStrTableName(String strTableName) {
        this.strTableName = strTableName;
    }
}
