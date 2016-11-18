package com.xin.jc.dagger2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 参考教程：http://www.jianshu.com/p/1d84ba23f4d2
 */
public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Inject
    Cloth cloth;

    @Inject
    Shose shose;

    @Inject
    Clothes clothes;

    //@Named("red")
    @RedCloth
    @Inject
    Cloth redCloth;

    //@Named("blue")
    @BlueCloth
    @Inject
    Cloth blueCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_text);

        //DaggerMainComponenct 要先build才会生成
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);
        tv.setText("我现在有" + cloth +  "和" +shose + "和"+ clothes+ "-----"+ blueCloth+","+redCloth+"\n"+
                "Cloth=clothes中的cloth吗?" + (cloth == clothes.getCloth()));

    }
}

/*
我们有两种方式可以提供依赖，一个是注解了@Inject的构造方法，一个是在Module里提供的依赖，
那么Dagger2是怎么选择依赖提供的呢，规则是这样的：
步骤1：查找Module中是否存在创建该类的方法。
步骤2：若存在创建类方法，查看该方法是否存在参数
步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数
步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
步骤3：若不存在创建类方法，则查找Inject注解的构造函数，看构造函数是否存在参数
步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数
步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
*/
