package org.cloudfun.design.pattern.structrue;

/**
 * Copyright @ 2019/6/5
 *
 * @author cloudgc
 * @since 0.0.1
 *
 * 当最终执行一个任务时，有多个维度的选择时 选用桥接模式
 *
 */
public class BridgePattern {

    interface Structrue{ String getStructrue();}

    static class FlowStuctrue implements Structrue{ @Override public String getStructrue() { return "Flow"; }}
    static class BaseStructrue implements Structrue{ @Override public String getStructrue() { return "Base"; }}


    interface Engine{ String getEngine();}

    static class TubineEngine implements  Engine{ @Override public String getEngine() { return "Tubin"; }}

    static class InHaleEngine implements  Engine{ @Override public String getEngine() { return "InHale"; }}



    interface Car {
        void driver();
    }

    static  class FullCar implements Car{

        private Structrue structrue;

        private Engine engine;


        public FullCar(Structrue structrue,Engine engine){
            this.structrue =structrue;
            this.engine=engine;
        }



        @Override
        public void driver() {
            System.out.println("I drive car, with:"+ structrue.getStructrue()
                    +" on:"+engine.getEngine());
        }
    }


    public static void main(String[] args) {
        Car car=new FullCar(new FlowStuctrue(),new TubineEngine());

        car.driver();

        Car car1=new FullCar(new BaseStructrue(),new TubineEngine());

        car1.driver();

        Car car2=new FullCar(new BaseStructrue(),new InHaleEngine());

        car2.driver();





    }






















}
