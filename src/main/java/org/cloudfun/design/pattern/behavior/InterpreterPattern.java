package org.cloudfun.design.pattern.behavior;

import java.util.Stack;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/13
 * <p>
 * 解释器模式，定义语法分析器构建语法树，定义终结符和非终结符，对于复杂语法难以维护
 * </p>
 */
public class InterpreterPattern {

    interface Interpreter {
        int interpreter();
    }

    static class NumberInterpreter implements Interpreter {
        private int number;

        NumberInterpreter(int number) {
            this.number = number;
        }

        @Override
        public int interpreter() {
            return this.number;
        }
    }

    static class PlusInterpreter implements Interpreter {

        private Interpreter left;
        private Interpreter right;

        PlusInterpreter(Interpreter left, Interpreter right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpreter() {
            return left.interpreter() + right.interpreter();
        }
    }

    static class MinusInterpreter implements Interpreter {
        private Interpreter left;
        private Interpreter right;

        MinusInterpreter(Interpreter left, Interpreter right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpreter() {
            return left.interpreter() - right.interpreter();
        }

    }

    static class MultiInterpreter implements Interpreter {
        private Interpreter left;
        private Interpreter right;

        MultiInterpreter(Interpreter left, Interpreter right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpreter() {
            return left.interpreter() * right.interpreter();
        }

    }


    static class DivisionInterpreter implements Interpreter {
        private Interpreter left;
        private Interpreter right;

        DivisionInterpreter(Interpreter left, Interpreter right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpreter() {
            return left.interpreter() / right.interpreter();
        }

    }

    static class ContextParse {


        public int parse(String string) {

            String s = string.replaceAll(" ", "");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {

            }


            return 0;
        }

    }


    public static void main(String[] args) {

        String a = "5*6*(1+2) + 1";
        ContextParse parse = new ContextParse();
        parse.parse(a);


    }


}
