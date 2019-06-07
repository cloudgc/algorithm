package org.cloudfun.design.pattern.structrue;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @ 2019/6/7
 *
 * @author cloudgc
 * @since 0.0.1
 *
 *  当 需要多维度去过滤一组数据可以 使用过滤模式
 *
 */
public class FilterPattern {

    static class Car {
        private String logo;
        private String engine;
        private String structure;

        @Override
        public String toString() {
            return "Car{" +
                    "logo='" + logo + '\'' +
                    ", engine='" + engine + '\'' +
                    ", structure='" + structure + '\'' +
                    '}';
        }

        public Car(String logo, String engine, String structure) {
            this.logo = logo;
            this.engine = engine;
            this.structure = structure;
        }

        public String getLogo() {

            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getStructure() {
            return structure;
        }

        public void setStructure(String structure) {
            this.structure = structure;
        }
    }


    interface CheckCar {
        List<Car> checkList(List<Car> cars);
    }

    static class CheckAudiCar implements CheckCar {

        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();

            for (Car car : cars) {
                if ("audi".equals(car.getLogo())) {
                    data.add(car);
                }
            }

            return data;
        }
    }

    static class CheckBMWCar implements CheckCar {
        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();

            for (Car car : cars) {
                if ("BMW".equals(car.getLogo())) {
                    data.add(car);
                }
            }

            return data;
        }
    }

    class CheckTurbineCar implements CheckCar {
        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();

            for (Car car : cars) {
                if ("turbine".equals(car.getEngine())) {
                    data.add(car);
                }
            }

            return data;
        }
    }

    class CheckInHareCar implements CheckCar {
        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();

            for (Car car : cars) {
                if ("hare".equals(car.getEngine())) {
                    data.add(car);
                }
            }

            return data;
        }
    }

    static class CheckAndCondition implements CheckCar {

        private CheckCar oneCondtion;

        private CheckCar otherCondition;

        public CheckAndCondition(CheckCar oneCondtion, CheckCar otherCondition) {
            this.oneCondtion = oneCondtion;
            this.otherCondition = otherCondition;
        }

        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();
            List<Car> cars1 = this.oneCondtion.checkList(cars);
            List<Car> cars2 = this.otherCondition.checkList(cars);
            data.addAll(cars1);
            data.addAll(cars2);
            return data;
        }
    }

    class CheckOrCondition implements CheckCar {

        private CheckCar oneCondtion;

        private CheckCar otherCondition;

        public CheckOrCondition(CheckCar oneCondtion, CheckCar otherCondition) {
            this.oneCondtion = oneCondtion;
            this.otherCondition = otherCondition;
        }

        @Override
        public List<Car> checkList(List<Car> cars) {

            List<Car> data = new ArrayList<>();
            List<Car> cars1 = this.oneCondtion.checkList(cars);
            List<Car> cars2 = this.otherCondition.checkList(cars);
            for (Car car : cars1) {
                if (!cars2.contains(car)) {
                    data.add(car);
                }
            }
            return data;
        }
    }


    public static void main(String[] args) {
        List<Car> data = new ArrayList<>();
        data.add(new Car("audi", "turbine", ""));
        data.add(new Car("BMW", "turbine", ""));
        data.add(new Car("VW", "turbine", ""));
        data.add(new Car("audi", "hare", ""));
        data.add(new Car("BMW", "hare", ""));
        data.add(new Car("VW", "hare", ""));

        CheckAudiCar checkAudiCar = new CheckAudiCar();
        CheckBMWCar checkBMWCar = new CheckBMWCar();

        CheckAndCondition checkAndCondition = new CheckAndCondition(checkAudiCar, checkBMWCar);

        List<Car> cars = checkAndCondition.checkList(data);

        for (Car car : cars) {
            System.out.println(car);
        }

    }


}
