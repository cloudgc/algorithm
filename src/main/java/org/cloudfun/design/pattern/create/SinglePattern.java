package org.cloudfun.design.pattern.create;

/**
 * Copyright @ 2019/6/2
 *
 * @author cloudgc
 * @since 0.0.1 主要解决：一个全局使用的类频繁地创建与销毁。
 */
public class SinglePattern {
    
    
    private static final SinglePattern obj = SinglePatternHolde.SINGLE_PATTERN;
    
    
    private static SinglePattern getInstance() {
        return obj;
    }
    
    private static class SinglePatternHolde {
        
        static final SinglePattern SINGLE_PATTERN = new SinglePattern();
    }
    
    public static void main(String[] args) {
        
        SinglePattern instance = SinglePattern.getInstance();
        
        System.out.println(instance);
        
        System.out.println(instance);
    }
    
}
