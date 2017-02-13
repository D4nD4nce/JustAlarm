package com.alarmproject.dandance.justalarm.enums;

public enum IMGEnum {

    NOTDONE(0),
    DONE(1);

    private int id;

    IMGEnum(int index) {
        id = index;
    }

    public int index() {
        return id;
    }
}
