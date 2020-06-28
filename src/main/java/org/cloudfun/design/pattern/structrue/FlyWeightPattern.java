package org.cloudfun.design.pattern.structrue;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright @ 2019/6/17
 *
 * @author cloudgc
 * @since 0.0.1 享元模式 1.大量小颗粒度的对象创建 2. 内部状态  不变 可以缓存起来 3. 外部状态  容易变化 使用统一入口接口
 */
public class FlyWeightPattern {
    
    static class Driver {
        
        String name;
        
        String gender;
        
        String purpose;
        
        public Driver(String name, String gender, String purpose) {
            this.name = name;
            this.gender = gender;
            this.purpose = purpose;
        }
    }
    
    interface Car {
        
        void driver(Driver driver);
    }
    
    static class BMWCar implements Car {
        
        
        @Override
        public void driver(Driver driver) {
            System.out.println("BMW Car:" + this.hashCode() + " driver:" + driver.name + ",gender:" + driver.gender
                    + "; driver Car for :" + driver.purpose + ". driver fast");
        }
    }
    
    static class VWCar implements Car {
        
        
        @Override
        public void driver(Driver driver) {
            System.out.println("VW Car:" + this.hashCode() + " driver:" + driver.name + ",gender:" + driver.gender
                    + "; driver Car for :" + driver.purpose + ". driver slow");
        }
    }
    
    
    static class CarFactory {
        
        private static Map<String, Car> cache = new HashMap<>();
        
        public static Car getCar(String name) {
            if (!cache.containsKey(name)) {
                if (name.equals("BMW")) {
                    cache.put("BMW", new BMWCar());
                } else {
                    cache.put("VW", new VWCar());
                }
            }
            
            return cache.get(name);
        }
        
        
    }
    
    public static void main(String[] args) {
        
        Car bmw = CarFactory.getCar("BMW");
        bmw.driver(new Driver("tom", "F", "catch mouse"));
        
        Car vw = CarFactory.getCar("VW");
        
        vw.driver(new Driver("beita", "F", "shopping"));
        
        Car bmw1 = CarFactory.getCar("BMW");
        
        bmw1.driver(new Driver("shuke", "F", "find beita"));
        
        
    }
    
}
