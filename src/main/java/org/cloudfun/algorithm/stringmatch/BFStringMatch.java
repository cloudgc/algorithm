package org.cloudfun.algorithm.stringmatch;

import org.springframework.util.StringUtils;

/**
 * Brute Force  match String A & String B
 */
public class BFStringMatch {
    
    public static void main(String[] args) {
        
        String patternString = "aaa";
        String originString = "asdasdasdaacabadas";
        boolean match = isMatch(originString, patternString);
        System.out.println(match);
        
    }
    
    
    public static boolean isMatch(String originString, String patternString) {
        if (StringUtils.isEmpty(originString) || StringUtils.isEmpty(patternString)) {
            return false;
        }
        
        if (originString.length() < patternString.length()) {
            return false;
        }
        
        int startIndex = 0;
        
        int endIndex = originString.length() - patternString.length();
        
        int patternLength = patternString.length();
        
        boolean flag = true;
        for (int i = 0; i < endIndex - startIndex; i++) {
            
            for (int j = 0; j < patternLength; j++) {
                if (originString.charAt(j + i) != patternString.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return true;
            } else {
                flag = true;
            }
        }
        return false;
        
    }
    
    
}
