package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/22
 * <p>
 * 类的行为是基于它的状态改变的
 * </p>
 *
 * <blockquote><pre>
 *     通过两个类的相互关联
 *     class A{
 *         void handle(B b){}
 *     }
 *
 *     class B{
 *         void handle(A a){}
 *     }
 * </pre></blockquote>
 */
public class StatePattern {


    enum Operator {
        /**
         * accelerator car
         */
        ACCELERATOR,
        /**
         * brake car
         */
        BRAKE
    }

    static class CarContext {
        int speed;

        Operator operator;

        State state = new GreenState();

        public void setState(State state) {
            this.state = state;
        }

        public Operator getOperator() {
            return operator;
        }

        public void setOperator(Operator operator) {
            this.operator = operator;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }


        void display(String color) {
            System.out.println("light:" + color + " on");
        }

        void request() {
            state.handler(this);
        }

    }


    static abstract class State {
        abstract void handler(CarContext context);
    }

    static class GreenState extends State {

        @Override
        void handler(CarContext context) {
            if (context.getSpeed() <= 80) {
                context.display("green");
            } else {
                context.setState(new YellowSate());
                context.request();
            }
        }
    }

    static class YellowSate extends State {

        @Override
        void handler(CarContext context) {
            if (context.getSpeed() > 80 && context.getSpeed() < 120) {
                context.display("yellow");
            } else {
                if (Operator.ACCELERATOR == context.getOperator()) {
                    context.setState(new RedState());
                    context.request();
                } else {
                    context.setState(new GreenState());
                    context.request();
                }
            }
        }
    }

    static class RedState extends State {

        @Override
        void handler(CarContext context) {
            if (context.getSpeed() >= 120) {
                context.display("red");
            } else {
                context.setState(new YellowSate());
                context.request();
            }
        }
    }


    public static void main(String[] args) {

        CarContext carContext = new CarContext();
        carContext.setOperator(Operator.ACCELERATOR);
        for (int i = 0; i < 150; i += 20) {
            carContext.setSpeed(i);
            carContext.request();
        }
        carContext.setOperator(Operator.BRAKE);
        for (int i = 150; i >= 0; i -= 20) {
            carContext.setSpeed(i);
            carContext.request();
        }

    }
}
