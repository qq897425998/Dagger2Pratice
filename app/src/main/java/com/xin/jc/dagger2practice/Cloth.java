package com.xin.jc.dagger2practice;

/**
 * Create by xin on 2016/11/18 14:52
 */
public class Cloth {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    @Override
    public String toString() {
        return color + "布料";
    }
}
