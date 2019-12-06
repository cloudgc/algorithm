package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/5
 */
public class QuickSort {

    /**
     * use left pivot
     *
     * @param array data
     * @param start start index
     * @param end   end index
     * @return final sort data
     */
    public int[] quickSort(int[] array, int start, int end) {

        if (end - start <= 0) {
            return null;
        }

        int pivotIndex = start;

        for (int i = start + 1; i < end; i++) {

            int pivot = array[pivotIndex];
            int compareData = array[i];
            if (compareData < pivot) {
                array[pivotIndex] = compareData;
                array[i] = pivot;

                int tmp = array[pivotIndex + 1];
                array[pivotIndex + 1] = array[i];
                array[i] = tmp;
                pivotIndex++;
            }

        }

        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);

        return array;
    }

    /**
     * use insert sort in pivot zone
     *
     * @param array data
     * @param start start index
     * @param end   end index
     * @return final sort data
     */

    public int[] quickSortRightPivot(int[] array, int start, int end) {

        if (end - start <= 0) {
            return null;
        }

        int pivot = array[end - 1];

        int j = start;
        for (int i = start; i < end - 1; i++) {
            int compareData = array[i];
            if (compareData <= pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                j++;
            }
        }

        array[end - 1] = array[j];
        array[j] = pivot;

        quickSort(array, start, end);
        quickSort(array, end + 1, end);

        return array;
    }


    public static void main(String[] args) {
        int[] data = {1, 8, 10, 60, 5, 6, 7, 4, 3, 9, 0};

        QuickSort quickSort = new QuickSort();

        // int[] ints = quickSort.quickSort(data, 0, data.length);
        //
        // System.out.println(Arrays.toString(ints));

        int[] dataOther = {1, 8, 10, 60, 5, 6, 7, 4, 3, 9, 0};

        int[] ints1 = quickSort.quickSortRightPivot(dataOther, 0, data.length);

        System.out.println(Arrays.toString(ints1));
    }


}
