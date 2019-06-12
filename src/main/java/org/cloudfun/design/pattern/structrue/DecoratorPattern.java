package org.cloudfun.design.pattern.structrue;

/**
 * Copyright @ 2019/6/12
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class DecoratorPattern {

    interface Car {
        void driver();
    }

    static class AudiCar implements Car {

        @Override
        public void driver() {
            System.out.println("this is Audi car on road ");
        }
    }

    static class BMWCar implements Car {

        @Override
        public void driver() {
            System.out.println("this is BMW car on road ");
        }
    }

    static abstract class AbstractCar implements Car {

        private Car car;

        public Car getCar() {
            return car;
        }

        public AbstractCar(Car car) {
            this.car = car;
        }

    }


    static class RedColorCar extends AbstractCar {

        public RedColorCar(Car car) {
            super(car);
        }

        @Override
        public void driver() {
            getCar().driver();
            System.out.println("this car is red");
        }
    }

    public static void main(String[] args) {

        AudiCar audiCar = new AudiCar();

        RedColorCar colorCar = new RedColorCar(audiCar);

        colorCar.driver();

        BMWCar bmwCar = new BMWCar();

        RedColorCar colorCar1 = new RedColorCar(bmwCar);

        colorCar1.driver();


    }


}
