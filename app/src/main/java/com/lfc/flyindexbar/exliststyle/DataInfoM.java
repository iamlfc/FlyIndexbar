package com.lfc.flyindexbar.exliststyle;

/**
 * Created by LFC
 * on 2018/8/27.
 */

public class DataInfoM {
    private int 数量;
    private String 名字;
    private int 类型;
    private String 时间;

    public DataInfoM() {
    }

    public DataInfoM(int 数量, String 名字, int 类型, String 时间) {
        this.数量 = 数量;
        this.名字 = 名字;
        this.类型 = 类型;
        this.时间 = 时间;
    }

    public int get数量() {
        return 数量;
    }

    public void set数量(int 数量) {
        this.数量 = 数量;
    }

    public String get名字() {
        return 名字 == null ? "" : 名字;
    }

    public void set名字(String 名字) {
        this.名字 = 名字;
    }

    public int get类型() {
        return 类型;
    }

    public void set类型(int 类型) {
        this.类型 = 类型;
    }

    public String get时间() {
        return 时间 == null ? "" : 时间;
    }

    public void set时间(String 时间) {
        this.时间 = 时间;
    }
}
