package org.cloudfun.design.pattern.structrue;

/**
 * Copyright @ 2019/6/16
 *
 * @author cloudgc
 * @since 0.0.
 * <p>
 * 外观模式
 * <p>
 * 大系统开机包含小系统开机
 */
public class FacadePattern {

    interface CarSystem {

        void start();

        void stop();
    }

    static class CarPlay implements CarSystem {

        @Override
        public void start() {
            System.out.println("CarPlay starting ... ");
        }

        @Override
        public void stop() {
            System.out.println("CarPlay ending ...");
        }
    }


    static class CarEngine implements CarSystem {

        @Override
        public void start() {
            System.out.println("Engine starting ...");
        }

        @Override
        public void stop() {
            System.out.println("Engine stop ...");
        }
    }

    static class AutoPull implements CarSystem {

        @Override
        public void start() {
            System.out.println("AutoPull start ....");
        }

        @Override
        public void stop() {
            System.out.println("AutoPoll stop ....");
        }
    }

    static class Car implements CarSystem {

        private CarPlay carPlay;

        private CarEngine carEngine;

        private AutoPull autoPull;

        public Car(CarPlay carPlay, CarEngine carEngine, AutoPull autoPull) {
            this.carPlay = carPlay;
            this.carEngine = carEngine;
            this.autoPull = autoPull;
        }

        @Override
        public void start() {
            this.autoPull.stop();
            this.carPlay.start();
            this.carEngine.start();

        }

        @Override
        public void stop() {

            this.carEngine.stop();
            this.carPlay.stop();
            this.autoPull.start();
        }
    }


    public static void main(String[] args) {

        Car car = new Car(new CarPlay(), new CarEngine(), new AutoPull());

        car.start();
        System.out.println("==================");

        car.stop();


    }


}
