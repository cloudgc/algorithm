package org.cloudfun.design.pattern.create;

/**
 * Copyright @ 2019/5/31
 *
 * @author cloudgc
 * @since 0.0.1
 * <p>
 * 创建一系列相互关联的类的接口， 但是不用指定实体类
 */
public class AbstractFactoryPattern {

    interface CarCreate {

        void createWheel();

        void createEngine();

    }

    static class BMWCarCreate implements CarCreate {

        @Override
        public void createWheel() {
            System.out.println("create bmw wheel .....");
        }

        @Override
        public void createEngine() {
            System.out.println("create bmw engine .....");

        }
    }


    static class AudiCarCreate implements CarCreate {

        @Override
        public void createWheel() {
            System.out.println("create audi wheel .....");
        }

        @Override
        public void createEngine() {

            System.out.println("create audi engine .....");
        }
    }


    interface CarSell {

        String getSellName();

    }

    static class BMWCarSell implements CarSell {

        @Override
        public String getSellName() {
            return "I am BMW Sell : Bob";
        }
    }

    static class AudiCarSell implements CarSell {

        @Override
        public String getSellName() {
            return "I am Audi Sell : Jack";

        }
    }


    interface CarFacotry {

        CarCreate getCarCreate(String name);

        CarSell getCarSeil(String name);
    }


    static class CarFactoryImp implements CarFacotry {

        @Override
        public CarCreate getCarCreate(String name) {

            if ("BMW".equals(name)) {
                return new BMWCarCreate();
            } else if ("audi".equals(name)) {
                return new AudiCarCreate();
            }

            return null;
        }

        @Override
        public CarSell getCarSeil(String name) {

            if ("BMW".equals(name)) {
                return new BMWCarSell();
            } else if ("audi".equals(name)) {
                return new AudiCarSell();
            }
            return null;
        }
    }


    public static void main(String[] args) {

        CarFactoryImp carFactoryImp = new CarFactoryImp();
        CarCreate bmw = carFactoryImp.getCarCreate("BMW");

        bmw.createWheel();
        bmw.createEngine();

        CarSell bmw1 = carFactoryImp.getCarSeil("BMW");
        System.out.println(bmw1.getSellName());

    }


}
