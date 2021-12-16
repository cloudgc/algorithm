package org.cloudfun.model.record;

public record Circle(Integer radius) implements Shape {
    
    public Circle{
        if(this.radius()==null){
            System.out.println(this.radius()+":::::");
        }
    }
    
    @Override
    public void area() {
    
    }
}
