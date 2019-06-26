package org.cloudfun.design.pattern.structrue;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Copyright @ 2019/6/26
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class ProxyPattern {

    interface Car {

        void driver();

    }

    public static class RealCar implements Car {

        @Override
        public void driver() {
            System.out.println("Real Car driving faster");
        }
    }

    static class JdkInvocationHandler implements InvocationHandler {

        private Car carObj;

        public JdkInvocationHandler(Car car) {
            this.carObj = car;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("jdk proxy car");
            if (method.getName().equals("driver")) {
                System.out.println("do some Checking ");
                return method.invoke(this.carObj, args);
            }
            return null;
        }
    }

    static class CglibProxy implements MethodInterceptor {

        private Object car;

        public CglibProxy(Object car) {
            this.car = car;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("cglib proxy");
            System.out.println("do some checking");
            return method.invoke(car, args);
        }

        static Object getProxy(Object car) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(car.getClass());
            enhancer.setCallback(new CglibProxy(car));
            return enhancer.create();
        }


    }


    public static void main(String[] args) {

        Car car = new RealCar();

        JdkInvocationHandler jdkInvocationHandler
                = new JdkInvocationHandler(car);

        Car o = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Car.class}, jdkInvocationHandler);

        o.driver();
        System.out.println("=============================");

        Car proxy = (Car) CglibProxy.getProxy(car);

        proxy.driver();


    }


}
