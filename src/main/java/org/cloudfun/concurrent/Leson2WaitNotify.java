package org.cloudfun.concurrent;

/**
 * @author cloudgc
 * @since 1/25/2021
 **/
public class Leson2WaitNotify {
    
    
    public static void main(String[] args) {
        Account account = new Account(0);
        
        Thread t1 = new Thread() {
            @Override
            public void run() {
                account.transform();
            }
        };
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                account.append();
            }
        };
        
        t1.start();
        t2.start();
        
        
    }
    
    
    static class Account {
        
        private Object lock = new Object();
        
        int balance;
        
        public Account(int balance) {
            this.balance = balance;
        }
        
        
        public synchronized void transform() {
            
            System.out.println("start transform");
            
            while (balance < 10) {
                try {
                    System.out.println("wait......");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("end transform");
            
            
        }
        
        
        public void append() {
            
            for (int i = 0; i < 4; i++) {
                
                synchronized (this) {
                    this.balance += 3;
                    // this.notifyAll();
                    this.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            
        }
    }
    
    
}
