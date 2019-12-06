package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * Copyright @ 2019/6/17
 *
 * @author cloudgc
 * @since 0.0.1
 * <p>
 * 选择排序，分为已排序空间，和未排序空间，在未排序区查找最小元素放入排序空间尾部
 * 原地排序
 * 不稳定排序
 * 时间复杂 最好O(n^2) 最坏O(N^2) 平均 O(n^2)
 * </p>
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

        int[] data = new int[]{1, 5, 7, 4, 0, 2};
        int[] ints = chooseSort(data);
        System.out.println(Arrays.toString(ints));


    }

}
