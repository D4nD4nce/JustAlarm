package com.alarmproject.dandance.justalarm.database;

import android.database.Cursor;
import android.graphics.drawable.Drawable;

import java.util.Date;

public class ObjectItem {

    private String strTitle;
    private String strDescription;
    private Date date;
    private Drawable image;

    public ObjectItem(){
    }

    public ObjectItem(String title, String description, Date date, Drawable image) {
        this.strTitle = title;
        this.strDescription = description;
        this.date = date;
        this.image = image;
    }

//    public ObjectItem(Cursor cursor){
//        if (cursor == null)
//            return;
//
//        this.strTitle = cursor.getString(cursor.getColumnIndex(DBNotes.COLUMN_TITLE_NOTES));
//        this.strDescription = cursor.getString(cursor.getColumnIndex(DBNotes.COLUMN_DESCRIPTION_NOTES));
//    }

    public void setInfo(Cursor cursor){
        if (cursor == null)
            return;

        this.clearData();

        this.strTitle = cursor.getString(cursor.getColumnIndex(DBNotes.COLUMN_TITLE_NOTES));
        this.strDescription = cursor.getString(cursor.getColumnIndex(DBNotes.COLUMN_DESCRIPTION_NOTES));
    }

    public String getTitle() {
        return strTitle;
    }

    public void setTitle(String title) {
        this.strTitle = title;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void clearData(){
        strTitle = null;
        strDescription = null;
        date = null;
        image = null;
    }
}
