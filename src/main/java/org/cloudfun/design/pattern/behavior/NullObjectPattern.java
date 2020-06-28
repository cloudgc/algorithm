package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/22
 * <p>
 * 空对象模型 java8 optional ????
 * </p>
 */
public class NullObjectPattern {
    
    static abstract class AbstractCustomer {
        
        protected String name;
        
        abstract boolean isNil();
        
        abstract String getName();
    }
    
    static class RealCustomer extends AbstractCustomer {
        
        RealCustomer(String name) {
            this.name = name;
        }
        
        @Override
        boolean isNil() {
            return false;
        }
        
        @Override
        String getName() {
            return this.name;
        }
    }
    
    static class NullCustomer extends AbstractCustomer {
        
        @Override
        boolean isNil() {
            return true;
        }
        
        @Override
        String getName() {
            return "IllegalName";
        }
    }
    
    static class CustomerFactory {
        
        public static final String[] names = {"Rob", "joe", "Julie"};
        
        public static AbstractCustomer getCustomer(String name) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(name)) {
                    return new RealCustomer(name);
                }
            }
            return new NullCustomer();
            
        }
        
    }
    
    public static void main(String[] args) {
        AbstractCustomer ff = CustomerFactory.getCustomer("ff");
        
        System.out.println(ff.isNil());
        System.out.println(ff.getName());
        
        AbstractCustomer rob = CustomerFactory.getCustomer("Rob");
        
        System.out.println(rob.isNil());
        System.out.println(rob.getName());
        
        
    }
}
