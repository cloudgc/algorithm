package org.cloudfun.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/13
 * <p>
 * 观察者模式，把消息的接收者和消息的传递解耦，当观察者较多导致效率下降
 * </p>
 */
public class ObserverPattern {

    interface Subject {

        void registerObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObserver();

    }

    interface Observer {
        void update(int date);
    }

    interface Display {
        void display();
    }

    static class OilData implements Subject {

        private List<Observer> observerList = new ArrayList<>();

        private int data;

        @Override
        public void registerObserver(Observer observer) {
            this.observerList.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            this.observerList.remove(observer);
        }

        public void setData(int data) {
            this.data = data;
            notifyObserver();
        }

        @Override
        public void notifyObserver() {
            observerList.forEach(ob -> ob.update(data));
        }
    }

    static class CarBroad implements Observer, Display {

        private Subject subject;
        private int data;

        CarBroad(Subject subject) {

            this.subject = subject;
            subject.registerObserver(this);
        }


        @Override
        public void update(int date) {
            this.data = date;
            display();
        }

        @Override
        public void display() {
            System.out.println("this car`s oil : " + data + "%");
        }
    }

    public static void main(String[] args) {

        OilData oilData = new OilData();

        CarBroad broad = new CarBroad(oilData);

        oilData.setData(100);

        oilData.setData(90);

        oilData.setData(80);

    }

}
