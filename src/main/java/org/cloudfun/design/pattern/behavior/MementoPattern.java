package org.cloudfun.design.pattern.behavior;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/13
 * <p>
 * 备份一个对象的中间状态，以便后续访问，同时可以恢复对象的状态到这一状态
 * </p>
 */
public class MementoPattern {
    
    static class State implements Cloneable {
        
        private int version;
        
        public int getVersion() {
            return version;
        }
        
        public void setVersion(int version) {
            this.version = version;
        }
        
        @Override
        protected State clone() throws CloneNotSupportedException {
            return (State) super.clone();
        }
    }
    
    static class Memento {
        
        State state;
        
        Memento(State state) {
            this.state = state;
        }
        
        public State getState() {
            return state;
        }
        
    }
    
    static class Originator {
        
        private State state;
        
        Originator() {
            this.state = new State();
            state.setVersion(0);
        }
        
        public Memento CreateMemento() {
            try {
                return new Memento(state.clone());
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
        
        public void getState() {
            System.out.println("originator state:" + this.state.getVersion());
        }
        
        public void addVersion() {
            this.state.setVersion(this.state.getVersion() + 1);
        }
        
        public void readMemento(Memento memento) {
            this.state = memento.getState();
        }
        
    }
    
    static class CareTaker {
        
        Map<String, Memento> mementos = new HashMap<>();
        
        public void addMemento(String key, Memento memento) {
            mementos.put(key, memento);
        }
        
        public Memento getMemento(String key) {
            return mementos.get(key);
        }
        
    }
    
    public static void main(String[] args) {
        
        Originator originator = new Originator();
        CareTaker taker = new CareTaker();
        
        originator.getState();
        
        taker.addMemento("0", originator.CreateMemento());
        
        originator.addVersion();
        originator.getState();
        
        originator.addVersion();
        originator.getState();
        
        Memento memento = taker.getMemento("0");
        
        originator.readMemento(memento);
        originator.getState();
        
    }
    
}
