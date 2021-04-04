/** 讲解<？ extends E>和<？ super E>的区别：https://www.cnblogs.com/xiarongjin/p/8309755.html　**/
package generic;

import generic.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public void upperBound(){
        //上限通配符的对象，可以指向其子类的对象，这就是上限通配的含义
        //那么有上限通配fruits定义的列表对象，可以被赋值为fruits及其子类的列表对象
        List<? extends Fruit> fruits;
        //Object是苹果的父类，所以不能将Object的数组列表赋值给fruits
        //fruits = new ArrayList<Object>();//编译不通过
        fruits = new ArrayList<Apple>();
        fruits = new ArrayList<Banana>();
        fruits = new ArrayList<TailandBanana>();
        //写入时，上限通配符对象，不能添加子类元素
        //因为 fruits中类型是不确定的，可以是apple也可以是banana
        //既然是不确定的，为了类型安全，编译器只能阻止添加元素了
        //fruits.add(new Banana());//编译不通过

        //读取时，上限通配符对象，可以读取子类对象，赋给上限对象（父类）
        // 注意此时的fruits指向TailandBanana的数组列表,Fruit为TailandBanana的父类
        //所以可以将TailandBanana赋值给fruits
        Fruit fruit = fruits.get(0);
        //<?>是<? extends Object>的简写
    }

    public void lowerBound(){
        //下限通配符，表示列表中元素的类型可以是Apple及其父类
       //那么有下限通配Apple定义的列表对象，可以被赋值为Apple及其父类的列表对象
        List<? super Apple> apples;
        apples = new ArrayList<Fruit>();
        //RedApple是Apple的子类，不能将其列表对象赋给下限通配的列表
        //apples = new ArrayList<RedApple>();//编译不通过
        //写入，可以添加苹果及其子类，下限可以确认写入类型
        apples.add(new Apple());
        apples.add(new RedApple());
        //apples.add(new Fruit());//编译不通过
        //读取，apple有可能指向Fruit的列表，所以，读取后直接赋值给apple是错误的
        //Apple apple = apples.get(0);//编译不通过
    }
}
