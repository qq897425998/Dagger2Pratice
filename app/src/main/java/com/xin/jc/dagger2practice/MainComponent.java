package com.xin.jc.dagger2practice;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Create by xin on 2016/11/18 14:57
 * @Component注解有modules和dependencies两个属性,这两个属性的类型都是Class数组,modules的作用就是声明该Component含有哪几个Module,
 * 当Component需要某个依赖对象时,就会通过这些Module类中对应的方法获取依赖对象,
 * MainComponent中只包含MainModule,所以令modules=MainModule.class,相当于供应商和商店老板确定合作关系
 */

@PerActivity
//@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
