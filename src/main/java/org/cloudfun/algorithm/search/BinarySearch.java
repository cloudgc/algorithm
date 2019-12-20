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

    /**
     * 正常查询
     *
     * @param array array
     * @param ele   find ele
     * @param start index start
     * @param end   index end
     * @return element index position
     */
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

        int[] dataa = {2, 5, 6, 7, 7, 7, 10, 78};
        int i1 = search.binarySearchFirstEle(dataa, 7);
        System.out.println("findFirst:" + i1);


    }


    /**
     * 查找数组中第一个 元素
     */
    public int binarySearchFirstEle(int[] array, int ele) {

        int start = 0;
        int end = array.length - 1;

        while ((end - start) >= 0) {

            int mid = start + (end - start) >> 1;
            if (array[mid] < ele) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        // 找到index 在比较
        if (start < array.length && array[start] == ele) {
            return start;
        }

        return -1;
    }


}
