package com.xin.jc.dagger2practice;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Create by xin on 2016/11/18 14:54
 * 写Module类时要在该类上声明@Module以表明该类是Module
 */
@Module
public class MainModule {

    /**
     * 那@Provides又是干嘛的呢?它的作用是声明Module类中哪些方法是用来提供依赖对象的,
     * 当Component类需要依赖对象时,他就会根据返回值的类型来在有@Provides注解的方法中选择调用哪个方法
     * @return
     */
    @PerActivity
    //@Singleton    //MainComponent总也要加，MainActivity中的Cloth对象和Clothes中的Cloth对象就是同一个对象了
    @Provides
    public Cloth getCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    /**
     *我们创建的这些依赖类都不用依赖于其它依赖类,但是如果需要依赖于其它依赖类又要怎么弄呢?
     *,这要怎么办呢?可能最先想到的办法就是这样:
     *  @Provides
     *  public Clothes getClothes(){
     *  Cloth cloth = new Cloth();
     *  cloth.setColor("红色");
     *  return new Clothes(cloth);
     *  }
     *
     * Dagger2提供了这样的功能,我们只要在getClothes方法中添加Cloth参数,
     * Dagger2就会像帮依赖需求方找依赖对象一样帮你找到该方法依赖的Cloth实例(单不是同一实例[单例]),所以我们代码可以这样
     */
    @Provides
    public Clothes getClothes( Cloth cloth){  //Qulifier、@Named("red") 两个注解还能使用在依赖参数上
        return new Clothes(cloth);
    }


    /**
     * 设我们现在又有了新的需求,MainActivity中需要两种布料,分别是红布料和蓝布料,
     * 但我们的MainModule类中只能提供红布料,怎么办呢
     * @Named注解,它怎么使用呢?它有一个value值,用来标识这个方法是给谁用的.修改我们的代码
     * @return
     */
    //@Named("red")
    @RedCloth
    @Provides
    public Cloth getRedCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }
    //@Named("blue")
    @BlueCloth
    @Provides
    public Cloth getBlueCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }


    @PerActivity
    @Provides
    ClothHandler getClothHandler(){
        return new ClothHandler();
    }
}
