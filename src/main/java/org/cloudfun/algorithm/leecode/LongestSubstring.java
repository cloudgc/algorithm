package org.cloudfun.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 *
 * @author cloudgc
 * @date 3/14/2023
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;

        int maxLength = 0;

        Map<Character, Integer> repeatContainer = new HashMap<>();

        while (right < s.length()) {
            char substring = s.charAt(right);
            if (repeatContainer.containsKey(substring) && repeatContainer.get(substring) >= left) {
                left = repeatContainer.get(substring) + 1;
            }
            repeatContainer.put(substring, right);
            maxLength = Math.max(maxLength, (right - left + 1));
            ++right;
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring2(s));


    }


}
