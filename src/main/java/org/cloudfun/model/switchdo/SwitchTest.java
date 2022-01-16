package org.cloudfun.model.switchdo;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author cloudgc
 * @since 12/18/2021
 **/
public class SwitchTest {
    
    public static void main(String[] args) {
        int value = LocalDate.now().getMonth().getValue();
        System.out.println(value);
        extracted(value);
        
        
    }
    
    private static int extracted(int value) {
        int days = switch (value + 1) {
            case Calendar.JANUARY, Calendar.MARCH -> 31;
            case Calendar.FEBRUARY -> {
                if (value % 4 == 0) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> 31;
        };
        
        
        
        switch (value){
            case Calendar.JANUARY, Calendar.MARCH -> value = 333;
            case Calendar.FEBRUARY -> {
                if (value % 4 == 0) {
                    System.out.println(value+":dos");
                } else {
                    System.out.println(value+":dosssss");
                }
            }
            // default -> System.out.println("default");
        }
        
        
        return days;
    }
    
}
