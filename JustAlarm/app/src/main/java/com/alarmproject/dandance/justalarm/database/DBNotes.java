package com.alarmproject.dandance.justalarm.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBNotes {

    private Context sqlCtx;
    private SQLiteDatabase sqlDB;
    private DBSQLiteOpenHelper sqlDBHelper;

    // данные бд
    private static final String DB_NAME = "GeneralDB";
    private static final int DB_VERSION = 1;

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

    public DBNotes(Context ctx)
    {
        sqlCtx = ctx;
    }

    public void openReadableDB()
    {
        if(sqlDBHelper != null) sqlDBHelper.close();
        sqlDBHelper = new DBSQLiteOpenHelper(sqlCtx, DB_NAME, null, DB_VERSION);
        sqlDBHelper.setStrCreateTable(DB_CREATE_MAIN_TABLE);
        sqlDB = sqlDBHelper.getReadableDatabase();
    }

    public void openWrightableDB()
    {
        if(sqlDBHelper != null) sqlDBHelper.close();
        sqlDBHelper = new DBSQLiteOpenHelper(sqlCtx, DB_NAME, null, DB_VERSION);
        sqlDBHelper.setStrCreateTable(DB_CREATE_MAIN_TABLE);
        sqlDB = sqlDBHelper.getWritableDatabase();
    }

    public void closeDB()
    {
        if(sqlDBHelper != null) sqlDBHelper.close();
    }

    public Cursor getAllData()
    {
        return sqlDB.query(DB_NOTES_TABLE, null, null,
                null, null, null, null );
    }

    public void deleteRecord(int id)
    {
        sqlDB.delete(DB_NOTES_TABLE, COLUMN_ID_NOTES + " = " + id, null);
    }

    public void addRecNotesTab (String descript, String title, int img)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DESCRIPTION_NOTES, descript);
        cv.put(COLUMN_TITLE_NOTES, title);
        cv.put(COLUMN_IMG_NOTES, img);
        sqlDB.insert(DB_NOTES_TABLE, null, cv);
    }

    public Cursor selectRecNotesTab (long id)
    {
        Cursor cursor = sqlDB.query(true, DB_NOTES_TABLE,
                new String[]{COLUMN_ID_NOTES, COLUMN_TITLE_NOTES, COLUMN_DESCRIPTION_NOTES},
                COLUMN_ID_NOTES + " = " + id, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public String selectRHeadLine (long id)
    {
        String txtHead;
        Cursor cursor = sqlDB.query(true, DB_NOTES_TABLE,
                new String[]{COLUMN_ID_NOTES, COLUMN_TITLE_NOTES, COLUMN_DESCRIPTION_NOTES},
                COLUMN_ID_NOTES + " = " + id, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
            txtHead = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE_NOTES));
            cursor.close();
        } else {
            txtHead = null;
        }
        return txtHead;
    }

    public String selectMainTxt (long id)
    {
        String txtMain;
        Cursor cursor = sqlDB.query(true, DB_NOTES_TABLE,
                new String[]{COLUMN_ID_NOTES, COLUMN_TITLE_NOTES, COLUMN_DESCRIPTION_NOTES},
                COLUMN_ID_NOTES + " = " + id, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            txtMain = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_NOTES));
            cursor.close();
        } else {
            txtMain = null;
        }
        return txtMain;
    }
}
