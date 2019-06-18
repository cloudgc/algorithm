package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * Copyright @ 2019/6/17
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class ChooseSort {


    public static int[] chooseSort(int[] data) {

        if (data == null || data.length == 0) {
            return data;
        }

        int len = data.length;

        for (int i = 0; i < len; i++) {

            int ele = data[len - 1];

            int tj = len - 1;
            for (int j = tj - 1; j >= i; j--) {
                int t = data[j];
                if (t < ele) {
                    tj = j;
                    ele = t;
                }
            }
            int ch = data[tj];
            data[tj] = data[i];
            data[i] = ch;
        }


        return data;
    }

    public static void main(String[] args) {

        int[] data = new int[]{1, 5, 7, 4, 0,2};
        int[] ints = chooseSort(data);
        System.out.println(Arrays.toString(ints));


    }

}
