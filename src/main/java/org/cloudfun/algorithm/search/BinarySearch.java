package org.cloudfun.algorithm.search;

import org.cloudfun.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/18
 */
public class BinarySearch {

    int findTime = 0;

    public int binarySearch(int[] array, int ele, int start, int end) {

        if ((end - start) < 0) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);

        findTime++;

        if (array[mid] == ele) {
            return mid;
        }


        if (array[mid] < ele) {
            return binarySearch(array, ele, mid + 1, end);
        } else {
            return binarySearch(array, ele, start, mid - 1);
        }

    }

    public static void main(String[] args) {

        int[] data = {5, 7, 4, 3, 6, 10, 22, 78, 1334, 35, 23, 234, 235, 1, 12, 11};
        QuickSort quickSort = new QuickSort();
        int[] sortData = quickSort.quickSort(data, 0, data.length);
        System.out.println(data.length);
        System.out.println(Arrays.toString(sortData));
        BinarySearch search = new BinarySearch();
        int i = search.binarySearch(sortData, 1334, 0, data.length - 1);
        System.out.println("index:" + i);
        System.out.println("useTime:" + search.findTime);
    }


}
