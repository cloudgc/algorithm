package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/21
 * <p>
 * 访问者模式 某对象结构中的各元素的操作，它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作
 * <p>
 * 通过方法的重载 来确定元素接收范围
 * </p>
 */
public class VisitorPatten {
    
    interface ComputerPartVisitor {
        
        public void visit(Computer computer);
        
        public void visit(Mouse mouse);
        
        public void visit(Keyboard keyboard);
        
        public void visit(Monitor monitor);
    }
    
    interface ComputerPart {
        
        public void accept(ComputerPartVisitor computerPartVisitor);
    }
    
    static class Keyboard implements ComputerPart {
        
        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }
    
    static class Monitor implements ComputerPart {
        
        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }
    
    static class Mouse implements ComputerPart {
        
        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }
    
    static class Computer implements ComputerPart {
        
        ComputerPart[] parts;
        
        public Computer() {
            parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
        }
        
        
        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            for (int i = 0; i < parts.length; i++) {
                parts[i].accept(computerPartVisitor);
            }
            computerPartVisitor.visit(this);
        }
    }
    
    static class ComputerPartDisplayVisitor implements ComputerPartVisitor {
        
        @Override
        public void visit(Computer computer) {
            System.out.println("Displaying Computer.");
        }
        
        @Override
        public void visit(Mouse mouse) {
            System.out.println("Displaying Mouse.");
        }
        
        @Override
        public void visit(Keyboard keyboard) {
            System.out.println("Displaying Keyboard.");
        }
        
        @Override
        public void visit(Monitor monitor) {
            System.out.println("Displaying Monitor.");
        }
    }
    
    
    public static void main(String[] args) {
        
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
    
    
}
