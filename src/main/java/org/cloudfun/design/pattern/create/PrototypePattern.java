package org.cloudfun.design.pattern.create;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright @ 2019/6/3
 *
 * @author cloudgc
 * @since 0.0.1 利用原型类 动态生成目标类 规避一些构造函数的约束
 */
public class PrototypePattern {
    
    static abstract class Car implements Cloneable {
        
        String logo;
        
        public void setLogo() {
        }
        
        abstract void driver();
        
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    
    static class AudiCar extends Car {
        
        @Override
        public void setLogo() {
            this.logo = "Auto";
        }
        
        
        @Override
        void driver() {
            System.out.println("driver slow");
        }
    }
    
    static class BMWCar extends Car {
        
        @Override
        public void setLogo() {
            this.logo = "BMW";
        }
        
        @Override
        void driver() {
            System.out.println("drive fast");
        }
    }
    
    static class CarCache {
        
        private static Map<String, Car> carcache = new ConcurrentHashMap<>();
        
        static {
            carcache.put("audi", new AudiCar());
            carcache.put("bmw", new BMWCar());
        }
        
        public static Car getCar(String name) throws CloneNotSupportedException {
            return (Car) carcache.get(name).clone();
        }
        
    }
    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        Car bmw = CarCache.getCar("bmw");
        bmw.driver();
        System.out.println(bmw);
        Car bmw1 = CarCache.getCar("bmw");
        System.out.println(bmw1);
        
        
    }
}
