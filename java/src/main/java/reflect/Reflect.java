package reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws Exception{
        //通过类的全限定名可以反射获得对象，并且获取构造函数、方法和属性，是框架自动注入的基础
        Class<?> cls = Class.forName("reflect.pojo.Person");
        Constructor<?> cons = cls.getConstructor();
        Object obj = cons.newInstance();
        Method setMethod = cls.getMethod("setAge",String.class);
        Method getMethod = cls.getMethod("getAge");
        setMethod.setAccessible(true);
        setMethod.invoke(obj,"20");
        System.out.println(obj);
        System.out.println(getMethod.invoke(obj));

        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }

    }
}
