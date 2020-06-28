package org.cloudfun.design.pattern.create;

/**
 * Copyright @ 2019/5/31
 *
 * @author cloudgc
 * @since 0.0.1
 * <p>
 * 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * <p>
 * interface>>car -------------- ↑      ↑ bmwcar audicar
 */
public class FactoryPattern {
    
    interface Car {
        
        void drive();
    }
    
    static class BMWCar implements Car {
        
        @Override
        public void drive() {
            System.out.println("drive faster");
        }
    }
    
    static class AudiCar implements Car {
        
        @Override
        public void drive() {
            System.out.println("drive slow");
        }
    }
    
    
    static class CarFactory {
        
        public static Car createCar(String name) {
            if ("BMW".equals(name)) {
                return new BMWCar();
            } else if ("audi".equals(name)) {
                return new AudiCar();
            }
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        
        Car bmw = CarFactory.createCar("BMW");
        
        bmw.drive();
        
        Car audi = CarFactory.createCar("audi");
        
        audi.drive();
        
        
    }
    
}
