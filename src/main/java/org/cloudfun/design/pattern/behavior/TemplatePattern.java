package org.cloudfun.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/21
 * <p>
 * 模板方法 把算法步骤抽象 不同的方式对应不同的实现
 * </p>
 */
public class TemplatePattern {
    
    interface OperatorCar {
        
        void engineStart();
        
        void engineStop();
    }
    
    static class CarContext {
        
        static List<OperatorCar> operatorCars = new ArrayList<>();
        
        
        static void registerOperator(OperatorCar operatorCar) {
            operatorCars.add(operatorCar);
        }
        
        static void startEngine() {
            operatorCars.stream().forEach(OperatorCar::engineStart);
        }
        
        static void stopEngine() {
            operatorCars.stream().forEach(OperatorCar::engineStop);
        }
        
    }
    
    static class LightOperator implements OperatorCar {
        
        @Override
        public void engineStart() {
            System.out.println("open light");
        }
        
        @Override
        public void engineStop() {
            
            System.out.println("close light");
            
        }
    }
    
    static class WiperOperator implements OperatorCar {
        
        @Override
        public void engineStart() {
            System.out.println("start wiper rain");
        }
        
        @Override
        public void engineStop() {
            System.out.println("close wiper rain");
        }
    }
    
    public static void main(String[] args) {
        
        CarContext.registerOperator(new WiperOperator());
        CarContext.registerOperator(new LightOperator());
        CarContext.startEngine();
        CarContext.stopEngine();
        
    }
    
    
}
