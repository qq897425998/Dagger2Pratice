package com.xin.jc.dagger2practice;

/**
 * Create by xin on 2016/11/18 15:46
 */
public class Clothes {
    private Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
    @Override
    public String toString() {
        return cloth.getColor() + "衣服";
    }
}
