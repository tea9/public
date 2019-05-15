package com.demo.dingsheng.entitiy;

/**
 * created by tea9 at 2018/12/7
 */
public class TabEntity {
    public boolean check=true;
    public String text;
    public int flag_enum;
    public TabEntity(String text) {
        this.text = text;
    }

    public TabEntity(String text,int flag_enum) {
        this.text = text;
        this.flag_enum = flag_enum;
    }
}
