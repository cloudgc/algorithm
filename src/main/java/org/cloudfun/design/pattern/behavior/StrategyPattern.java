package org.cloudfun.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/20
 * <p>
 * 策咯模式，把一系列的类似算法封装，开箱即用
 * </p>
 */
public class StrategyPattern {
    
    
    static abstract class Calculation {
        
        private int elementOne;
        
        private int elementTwo;
        
        private String symbol;
        
        public int getElementOne() {
            return elementOne;
        }
        
        public void setElementOne(int elementOne) {
            this.elementOne = elementOne;
        }
        
        public int getElementTwo() {
            return elementTwo;
        }
        
        public void setElementTwo(int elementTwo) {
            this.elementTwo = elementTwo;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
        
        Calculation(int elementOne, int elementTwo, String symbol) {
            setElementOne(elementOne);
            setElementTwo(elementTwo);
        }
        
        abstract int calculation();
    }
    
    static class PlusAlgorithm extends Calculation {
        
        PlusAlgorithm(int elementOne, int elementTwo, String symbol) {
            super(elementOne, elementTwo, symbol);
        }
        
        @Override
        public int calculation() {
            return getElementOne() + getElementTwo();
        }
    }
    
    static class MinusAlgorithm extends Calculation {
        
        MinusAlgorithm(int elementOne, int elementTwo, String symbol) {
            super(elementOne, elementTwo, symbol);
        }
        
        @Override
        int calculation() {
            return getElementOne() - getElementTwo();
        }
    }
    
    static class Context {
        
        List<Calculation> algorithms = new ArrayList<>();
        
        public static Calculation getCalculatuin(int a, int b, String symbol) {
            if (symbol.equals("+")) {
                return new PlusAlgorithm(a, b, symbol);
            } else {
                return new MinusAlgorithm(a, b, symbol);
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        
        int first = 10;
        int second = 5;
        String symbol = "+";
        
        Calculation calculatuin = Context.getCalculatuin(first, second, symbol);
        int calculation = calculatuin.calculation();
        System.out.println("this is result:" + calculation);
    }
    
    
}
