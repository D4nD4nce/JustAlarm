package com.alarmproject.dandance.justalarm.adaptersstaff;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class ObjectItem {

    private String title;
    private Date date;
    private Drawable image;

    public ObjectItem(String title, Date date, Drawable image) {
        this.title = title;
        this.date = date;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
