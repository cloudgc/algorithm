package org.cloudfun.design.pattern.behavior;

/**
 * Copyright @ 2019/6/26
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class ChainOfResponsibilityPattern {


    public static abstract class AbstractAccidentDeal {

        protected int accidentCost;

        public AbstractAccidentDeal(int costLevel) {
            this.accidentCost = costLevel;
        }

        protected AbstractAccidentDeal nextAccidentDeal;

        protected void setNextAccidentDeal(AbstractAccidentDeal accidentDeal) {
            this.nextAccidentDeal = accidentDeal;
        }

        public void payCost(int cost, String message) {
            if (this.accidentCost >= cost) {
                payMoney(message);
            } else {
                if (this.nextAccidentDeal != null) {
                    this.nextAccidentDeal.payCost(cost, message);
                }
            }
        }

        protected abstract void payMoney(String message);
    }

    public static class SelfDeal extends AbstractAccidentDeal {

        public SelfDeal(int costLevel) {
            super(costLevel);
        }

        @Override
        protected void payMoney(String message) {

            System.out.println("self pay the bill for:" + message);

        }
    }

    public static class FourSDeal extends AbstractAccidentDeal {

        public FourSDeal(int costLevel) {
            super(costLevel);
        }

        @Override
        protected void payMoney(String message) {

            System.out.println("4s pay the bill for:" + message);
        }
    }

    public static class InsuranceDeal extends AbstractAccidentDeal {

        public InsuranceDeal(int costLevel) {
            super(costLevel);
        }

        @Override
        protected void payMoney(String message) {

            System.out.println("Insurance pay the bill for:" + message);
        }
    }


    static AbstractAccidentDeal getDealChain() {
        SelfDeal selfDeal = new SelfDeal(200);
        FourSDeal fourSDeal = new FourSDeal(10000);
        InsuranceDeal insuranceDeal = new InsuranceDeal(100000);

        selfDeal.nextAccidentDeal = fourSDeal;
        fourSDeal.nextAccidentDeal = insuranceDeal;


        return selfDeal;

    }

    public static void main(String[] args) {

        AbstractAccidentDeal dealChain = getDealChain();
        dealChain.payCost(100, "head scratch");

        dealChain.payCost(512, "wheel lost");

        dealChain.payCost(30100, "engine damage");


    }


}
