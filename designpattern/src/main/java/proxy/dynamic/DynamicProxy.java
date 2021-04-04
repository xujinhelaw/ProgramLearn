package proxy.dynamic;

import proxy.GamPlayer;
import proxy.GamPlayerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;//被代理的对象

    public DynamicProxy(Object target){
        this.target = target;
    }

    //动态代理类调用upgrade方法，先调用InvocationHandler中的invoke，再通过invoke调用被代理类gamplayer的方法
    //proxy 代理类的实例，可以用来获取代理对象的信息和可以将代理对象返回进行连续调用，其他时候都无作用
    public Object invoke(Object proxy,Method method,Object[] args) throws Exception{
        System.out.println("proxy = " + proxy.getClass().getName() );
        System.out.println("我是前置通知"); //每个方法执行前的前置通知
        Object result = method.invoke(target,args);
        System.out.println("我是后置通知"); //每个方法执行后的后置通知
        return result;
    }

    public static Object getDynamicProxy(Object target){
        InvocationHandler invocationHandler = new DynamicProxy(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),invocationHandler);
    }

    public static void main(String[] args) {
        GamPlayer gamPlayer = new GamPlayerImpl();
        GamPlayer dynamicGamPlayer =(GamPlayer) DynamicProxy.getDynamicProxy(gamPlayer);
        dynamicGamPlayer.upgrade();
        dynamicGamPlayer.killBoss();
    }
}
