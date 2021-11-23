package org.cloudfun.concurrent;

/**
 * @author cloudgc
 * @since 1/22/2021
 *
 *
 **/
public class Leson1 {
    
    static Singleton instance;
    
    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
    
    static class Singleton {
        
        private String test;
        
    }
    
    
    public static void main(String[] args) {
        Thread a = new Thread(Leson1::getInstance);
        Thread b = new Thread(Leson1::getInstance);
        a.start();
        b.start();
        
    }
    
}
