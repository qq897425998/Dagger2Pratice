package com.xin.jc.dagger2practice;

import javax.inject.Inject;

/**
 * Create by xin on 2016/11/18 15:33
 * 其实Dagger2还可以用注解来提供依赖对象.让我们来瞧瞧
 */
public class Shose {
    /**
     * 创建的方式和Cloth不一样了,我们在构造函数上声明了@Inject注解
     *
     * 当Component在所拥有的Module类中找不到依赖需求方需要类型的提供方法时,
     * Dagger2就会检查该需要类型的有没有用@Inject声明的构造方法,有则用该构造方法创建一个
     *
     *
     * 注意为什么不都用这种方法来声明呢?为什么要用Module类?
     * 答案是这样的,项目中我们会用到别人的jar包,我们无法修改别人的源码,就更别说在人家的类上添加注解了,
     * 所以我们只能通过Module类来提供.
     */
    @Inject
    public Shose(){
    }

    @Override
    public String toString() {
        return "鞋子";
    }
}
