package com.demo.android_ds.entity;

/**
 */
public class TabEntity {
    public boolean check=true;
    public String text;
    public int flag_enum;
    public int time_flag;//1是before2是after
    public TabEntity(String text) {
        this.text = text;
    }

    public TabEntity(String text, int flag_enum) {
        this.text = text;
        this.flag_enum = flag_enum;
    }

    public TabEntity(String text, int flag_enum, int time_flag) {
        this.text = text;
        this.flag_enum = flag_enum;
        this.time_flag = time_flag;
    }
}
