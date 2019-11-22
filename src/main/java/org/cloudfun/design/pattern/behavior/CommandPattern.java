package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/13
 * <p>
 * 命令模式,将请求封装为对象，以便使用不同的请求来参数化其他对象
 * </p>
 */
public class CommandPattern {

    interface LightReceiver {
        void action();
    }

    static class LightOnReceiver implements LightReceiver {
        private String name;

        LightOnReceiver(String name) {
            this.name = name;
        }

        @Override
        public void action() {

            System.out.println(this.name + ": light on");
        }
    }

    static class LightOffReceiver implements LightReceiver {
        private String name;

        LightOffReceiver(String name) {
            this.name = name;
        }

        @Override
        public void action() {

            System.out.println(this.name + ": light off");
        }
    }


    interface Command {
        void execute();
    }

    static class LightOnCommand implements Command {

        private LightReceiver light;

        LightOnCommand(LightReceiver light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.action();
        }
    }

    class LightOffCommand implements Command {

        private LightReceiver light;

        LightOffCommand(LightReceiver light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.action();
        }
    }

    static class Invoke {
        private Command command;

        void setCommand(Command command) {
            this.command = command;
        }

        public void doAction() {
            this.command.execute();
        }
    }

    public static void main(String[] args) {
        LightOnReceiver receiver = new LightOnReceiver("front");

        LightOffReceiver lightOffReceiver = new LightOffReceiver("rear");

        LightOnCommand command = new LightOnCommand(receiver);
        Invoke invoke = new Invoke();
        invoke.setCommand(command);
        invoke.doAction();


    }
}
