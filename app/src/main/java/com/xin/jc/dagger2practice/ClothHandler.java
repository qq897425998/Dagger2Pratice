package com.xin.jc.dagger2practice;

/**
 * Create by xin on 2016/11/18 17:23
 * 在实际开发中,我们经常会使用到工具类,
 * 工具类一般在整个App的生命周期内都是单例的,
 * 我们现在给我们的Demo添加一个工具类ClothHandler:
 */
public class ClothHandler {
    public Clothes handle(Cloth cloth){
        return new Clothes(cloth);
    }
}
