package org.cloudfun.design.pattern.behavior;

/**
 * @author 88447351
 * @apiNote
 * @date 2019/11/26
 */
public class CompositeEntityDesignPattern {
    
    static class DependentObject1 {
        
        private String data;
        
        public void setData(String data) {
            this.data = data;
        }
        
        public String getData() {
            return data;
        }
    }
    
    static class DependentObject2 {
        
        private String data;
        
        public void setData(String data) {
            this.data = data;
        }
        
        public String getData() {
            return data;
        }
        
        
    }
    
    static class CoarseGrainedObject {
        
        DependentObject1 do1 = new DependentObject1();
        
        DependentObject2 do2 = new DependentObject2();
        
        public void setData(String data1, String data2) {
            do1.setData(data1);
            do2.setData(data2);
        }
        
        public String[] getData() {
            return new String[] {do1.getData(), do2.getData()};
        }
    }
    
    static class CompositeEntity {
        
        private CoarseGrainedObject cgo = new CoarseGrainedObject();
        
        public void setData(String data1, String data2) {
            cgo.setData(data1, data2);
        }
        
        public String[] getData() {
            return cgo.getData();
        }
    }
    
    static class Client {
        
        private CompositeEntity compositeEntity = new CompositeEntity();
        
        public void printData() {
            for (int i = 0; i < compositeEntity.getData().length; i++) {
                System.out.println("Data: " + compositeEntity.getData()[i]);
            }
        }
        
        public void setData(String data1, String data2) {
            compositeEntity.setData(data1, data2);
        }
    }
    
    
    public static void main(String[] args) {
        Client client = new Client();
        client.setData("Test", "Data");
        client.printData();
        client.setData("Second Test", "Data1");
        client.printData();
    }
    
    
}
