package com.alarmproject.dandance.justalarm.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.alarmproject.dandance.justalarm.database.DBSQLiteOpenHelper.*;

public class DBGeneral {

    private Context sqlCtx;
    private SQLiteDatabase sqlDB;
    private DBSQLiteOpenHelper sqlDBHelper;

    // данные бд
    private static final String DB_NAME = "GeneralDB";
    private static final int DB_VERSION = 1;

    DBGeneral(Context ctx)
    {
        sqlCtx = ctx;
    }

    public void openReadableDB()
    {
        sqlDBHelper = new DBSQLiteOpenHelper(sqlCtx, DB_NAME, null, DB_VERSION);
        sqlDB = sqlDBHelper.getReadableDatabase();
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
