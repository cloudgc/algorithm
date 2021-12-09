package org.cloudfun.algorithm.string;

import org.springframework.util.StringUtils;

/**
 * Rabin-Karp
 * <p>
 * <p>
 * h[i] = (h[i-1] - 26^(m-1)* S[i-1] - 'a' )*26 +26^0 * (s[i+m-1 -'a')
 */
public class RKStrigMatch {
    
    
    private static final int[] DICT_HASH = {1, 4, 4 * 4, 4 * 4 * 4};
    
    public static void main(String[] args) {
        String originString = "abaadcaabaaab";
        String patternString = "aaa";
        boolean isMatch = matchString(originString, patternString);
        
        System.out.println(isMatch);
    }
    
    private static boolean matchString(String originString, String patternString) {
        
        if (StringUtils.isEmpty(originString) || StringUtils.isEmpty(patternString)) {
            return false;
        }
        
        if (originString.length() < patternString.length()) {
            return false;
        }
        
        int patternLength = patternString.length();
        
        //        int patternHash = hash(patternString);
        // hard
        //        for (int i = 0; i <= originString.length() - patternLength; i++) {
        //            String substring = originString.substring(i, i + patternLength);
        //            int subHash = hash(substring);
        //            if (subHash == patternHash) {
        //                return true;
        //            }
        //        }
        
        //        int firstHash = hash(originString.substring(originString.length()-patternLength, originString.length()));
        
        //        h[i] = (h[i-1] - 26^(m-1)* S[i-1] - 'a' )*26 +26^0 * (s[i+m-1] -'a')
        //        for (int i = originString.length()-1; i>=patternLength; i--) {
        //            String substring = originString.substring(i-patternLength, i);
        //            26*(firstHash - DICT_HASH[patternLength-1] *
        //        }
        int patternHash = hash(patternString);
        int firstHash = hash(originString.substring(0, patternLength));
        
        if (patternHash == firstHash) {
            return true;
        }
        
        for (int i = 1; i <= originString.length() - patternLength; i++) {
            System.out.println(originString.substring(i, i + patternLength));
            
            int hash = 4 * (firstHash - DICT_HASH[patternLength - 1] * originString.charAt(i-1 )) + originString
                    .charAt(i + patternLength - 1);
            if (patternHash == hash) {
                return true;
            }
            firstHash = hash;
        }
        
        return false;
    }
    
    private static int hash(String patternString) {
        int length = patternString.length();
        int hash = 0;
        for (int i = patternString.length() - 1; i >= 0; --i, --length) {
            int c = patternString.charAt(i);
            hash += getSquar(length - 1) * c;
            
        }
        return hash;
    }
    
    
    static int getSquar(int index) {
        int j = 1;
        for (int i = 0; i < index; i++) {
            j *= 4;
        }
        return j;
    }
    
    
}
