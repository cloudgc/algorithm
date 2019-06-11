package org.cloudfun.design.pattern.create;

import org.junit.Before;

/**
 * Copyright @ 2019/6/2
 *
 * @author cloudgc
 * @since 0.0.1
 * 当需要构建一个复杂对象的时候，通常由子部分完成，
 * 当复杂对象变化的时候，组合算法相对固定
 */
public class BuilderPatten {

    interface Car {

        Bracket carBracket();

        Engine carEngine();

        GearBox carGearBox();

        String getConfigList();

    }

    abstract static class AbstractCar implements Car {
        @Override
        public String getConfigList() {
            return "Car Config: bracket(" + carBracket().getBracketType() + "), "
                    + "engine(" + carEngine().getEngineType() + "), "
                    + "gearbox(" + carGearBox().getGearBoxType() + ")....";
        }
    }

    interface Bracket {
        String getBracketType();
    }

    static class SUVBracket implements Bracket {
        @Override
        public String getBracketType() {
            return "SUV";
        }
    }

    class MINIBracket implements Bracket {
        @Override
        public String getBracketType() {
            return "MINI";
        }
    }

    interface Engine {
        String getEngineType();

    }

    class TurbineEngine implements Engine {
        @Override
        public String getEngineType() {
            return "Turbine";
        }
    }

    static class ElectEngine implements Engine {
        @Override
        public String getEngineType() {
            return "Elect";
        }
    }

    interface GearBox {
        String getGearBoxType();
    }

    class HandGearBox implements GearBox {
        @Override
        public String getGearBoxType() {
            return "Hand";
        }
    }

    static class AutoGearBox implements GearBox {
        @Override
        public String getGearBoxType() {
            return "Auto";
        }
    }


    static class CarBuilder {

        private Bracket bracket;

        private Engine engine;

        private GearBox gearBox;

        Car buildCar() {
            return new AbstractCar() {
                @Override
                public Bracket carBracket() {
                    return bracket;
                }

                @Override
                public Engine carEngine() {
                    return engine;
                }

                @Override
                public GearBox carGearBox() {
                    return gearBox;
                }
            };
        }

        CarBuilder bracket(Bracket bracket) {
            this.bracket = bracket;
            return this;
        }

        CarBuilder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        CarBuilder gearBox(GearBox gearBox) {
            this.gearBox = gearBox;
            return this;
        }

    }


    public static void main(String[] args) {

        CarBuilder carBuilder = new CarBuilder();

        carBuilder.bracket(new SUVBracket())
                .engine(new ElectEngine())
                .gearBox(new AutoGearBox());

        Car car = carBuilder.buildCar();

        System.out.println(car.getConfigList());


    }
}
