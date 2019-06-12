package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * Copyright @ 2019/6/12
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class BubbleSort {


    public static int[] bubble(int[] data) {

        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[i] < data[j]) {
                    int t = data[j];
                    data[j] = data[i];
                    data[i] = t;
                }
            }
        }


        return data;
    }

    public static void main(String[] args) {

        int[] data = new int[]{3, 2, 5, 4, 1};

        int[] bubble = bubble(data);
        System.out.println(Arrays.toString(bubble));


    }

}
