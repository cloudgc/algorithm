package org.cloudfun.algorithm.arrays;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Copyright @ 2019/3/31
 *
 * @author cloudgc
 * @since 0.0.1
 * 反转一个数组
 */
public class ArraysReverseString {


    /**
     * reverse string
     */
    String reverseString(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();

        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {

            char tmp = chars[i];

            chars[i] = chars[j];

            chars[j] = tmp;
        }

        return new String(chars);
    }


    /**
     *
     */

    @Test
    public void reverseTest1() {

        String res = reverseString("Helbo");

        Assert.isTrue("obleH".equals(res), "not pass");

    }

/*    public static void main(String[] args) {

        System.out.println(reverseString("Helbo"));


    }*/

}
