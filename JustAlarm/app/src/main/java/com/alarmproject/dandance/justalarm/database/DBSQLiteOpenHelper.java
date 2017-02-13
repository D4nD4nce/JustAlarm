package com.alarmproject.dandance.justalarm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLiteOpenHelper extends SQLiteOpenHelper {

    // названия таблиц
    static final String DB_NOTES_TABLE = "notesTabDb";

    // таблица заметок
    static final String COLUMN_ID_NOTES = "_id";
    static final String COLUMN_IMG_NOTES = "imgNOTE";
    static final String COLUMN_TITLE_NOTES = "titleNOTE";
    static final String COLUMN_DESCRIPTION_NOTES = "descriptionNOTE";

    private static final String DB_CREATE_MAIN_TABLE =
            "create table " + DB_NOTES_TABLE + " (" + COLUMN_ID_NOTES +
                    " integer primary key autoincrement, " + COLUMN_IMG_NOTES + " integer, "
                    + COLUMN_TITLE_NOTES + " text, " + COLUMN_DESCRIPTION_NOTES + " text" + ");";

    DBSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                       int version)
    {
        super(context, name, factory, version);
    }

    //создаем и заполняем БД
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // создание таблиц
        db.execSQL(DB_CREATE_MAIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists " + DB_NOTES_TABLE);
        this.onCreate(db);
    }

}
