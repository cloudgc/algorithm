package org.cloudfun.design.pattern.behavior;

import org.springframework.util.StringUtils;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/19
 * <p>
 * 中介者模式 使用抽象中介者 完成类型对象之间的交互
 * </p>
 */
public class MediatorPattern {
    
    
    interface CarMediator {
        
        void transaction(Trader sell, Trader buyer);
        
        
    }
    
    static class SomeBadCarMediator implements CarMediator {
        
        private int dirtyMoney;
        
        public int getDirtyMoney() {
            return dirtyMoney;
        }
        
        @Override
        public void transaction(Trader sell, Trader buyer) {
            buyer.setMoney(buyer.getMoney() - 10000);
            dirtyMoney += 10000;
            sell.setMoney(buyer.getMoney());
            sell.doTransaction();
            buyer.setCarName(sell.getCarName());
        }
    }
    
    
    static abstract class Trader {
        
        private int money;
        
        private String carName;
        
        Trader(int money, String carName) {
            this.money = money;
            this.carName = carName;
        }
        
        public int getMoney() {
            return money;
        }
        
        public void setMoney(int money) {
            this.money = money;
        }
        
        public String getCarName() {
            return carName;
        }
        
        public void setCarName(String carName) {
            this.carName = carName;
        }
        
        abstract void doTransaction();
        
    }
    
    static class TraderSeller extends Trader {
        
        TraderSeller(int money, String carName) {
            super(money, carName);
        }
        
        
        TraderSeller() {
            super(0, null);
        }
        
        
        @Override
        void doTransaction() {
            if (getMoney() < 0) {
                setCarName("hammer");
            } else if (getMoney() > 0 && getMoney() < 300000) {
                setCarName("VW");
            } else {
                setCarName("BMW");
            }
        }
    }
    
    static class TraderBuyer extends Trader {
        
        
        public TraderBuyer(int money, String carName) {
            super(money, carName);
        }
        
        public TraderBuyer(int money) {
            super(money, null);
        }
        
        @Override
        void doTransaction() {
            if (StringUtils.isEmpty(getCarName())) {
                setMoney(0);
            } else if (getCarName().equals("VW")) {
                setMoney(100000);
            } else {
                setMoney(10000000);
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        SomeBadCarMediator badCarMediator = new SomeBadCarMediator();
        
        TraderBuyer buyer = new TraderBuyer(200000);
        TraderSeller seller = new TraderSeller();
        
        badCarMediator.transaction(seller, buyer);
        
        System.out.println("badMediator get:" + badCarMediator.getDirtyMoney());
        
        System.out.println("buyer get car:" + buyer.getCarName());
        
        System.out.println("seller get money:" + seller.getMoney());
        
        
    }
    
}
