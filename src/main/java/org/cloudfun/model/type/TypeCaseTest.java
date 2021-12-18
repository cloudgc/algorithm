package org.cloudfun.model.type;

import java.awt.*;

/**
 * @author cloudgc
 * @since 12/16/2021
 **/
public class TypeCaseTest {
    
    public static void main(String[] args) {
        
        Car aov = new AOV();
        
        Car bmw = new Bmw();
        
        test(aov, bmw);
        
    }
    
    private static void test(Car aov, Car bmw) {
        if (aov instanceof AOV vc) {
            vc.Aov();
        }
        
        if(!(bmw instanceof Bmw bw)){
            System.out.println("not");
        }else {
            bw.bmw();
        }
        
        
        
        
        
    }
    
    // public static boolean isSquareImplC(Shape shape) {
    //     return shape instanceof Square ||  // rect is not in scope here
    //             (shape instanceof Rectangle rect &&
    //                     rect.length() == rect.width());   // rect is in scope here
    // }
    
    
}
