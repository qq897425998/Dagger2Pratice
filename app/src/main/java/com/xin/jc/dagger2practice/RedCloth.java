package com.xin.jc.dagger2practice;

import javax.inject.Qualifier;

/**
 * Create by xin on 2016/11/18 16:10
 * @Qulifier功能和@Named一样,并且@Named就是继承@Qulifier的,
 * 我们要怎么使用@Qulifier注解呢?答案就是自定义一个注解:
 * 而且这两个注解还能使用在依赖参数上,比如这个:
 *   @Provides
 *   public Clothes getClothes(@Named("blue") Cloth cloth){
 *   return new Clothes(cloth);
 *   }
 */
@Qualifier
public @interface RedCloth {
}
