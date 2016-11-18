package com.xin.jc.dagger2practice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Create by xin on 2016/11/18 16:41
 * 这个注解有什么用呢?答案就是声明作用范围
 * 当我们将这个注解使用在Module类中的Provide方法上时,就是声明这个Provide方法是在PerActivity作用范围内的
 * 并且当一个Component要引用这个Module时,必须也要声明这个Component是PerActivity作用范围内的,否则就会报错
 * 声明方法也很简单,就是在Component接口上使用这个注解
 *
 * 但是我们声明这个作用范围又有什么用呢?
 * Dagger2有这样一个机制:在同一个作用范围内,Provide方法提供的依赖对象就会变成单例
 * 也就是说依赖需求方不管依赖几次Provide方法提供的依赖对象,Dagger2都只会调用一次这个方法.
 * 就和上面那个例子一样,正常情况下,
 * 在注入MainActivity中的Cloth对象时会调用一次getCloth方法,注入Clothes对象时因为依赖Cloth对象,
 * 所以又会调用一次getCloth方法,导致这两个Cloth对象并不是同一个实例.
 * 但是我们给它声明作用范围后,这两次对Cloth的依赖只会调用一次getCloth方法,这样这两个Cloth对象就是同一实例了,
 * 这样就保证了在给MainActivity注入时,所有声明的Cloth依赖都是指向同一个实例
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
