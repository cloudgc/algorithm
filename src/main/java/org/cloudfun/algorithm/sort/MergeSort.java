package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/28
 * <p>
 * 归并排序
 * </p>
 */
public class MergeSort {

    public int[] mergeSort(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int i = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, i);
        int[] right = Arrays.copyOfRange(array, i, array.length);

        int[] leftMerge = mergeSort(left);
        int[] rightMerge = mergeSort(right);
        return mergeData(leftMerge, rightMerge);
    }

    private int[] mergeData(int[] leftMerge, int[] rightMerge) {
        int[] finalData = new int[leftMerge.length + rightMerge.length];

        int indexLeft = 0;
        int indexRight = 0;
        do {
            if (indexLeft >= leftMerge.length) {
                finalData[indexLeft + indexRight] = rightMerge[indexRight];
                indexRight++;
                continue;
            }
            if (indexRight >= rightMerge.length) {
                finalData[indexLeft + indexRight] = leftMerge[indexLeft];
                indexLeft++;
                continue;
            }

            int left = leftMerge[indexLeft];
            int right = rightMerge[indexRight];
            if (left > right) {
                finalData[indexLeft + indexRight] = right;
                indexRight++;
            } else {
                finalData[indexLeft + indexRight] = left;
                indexLeft++;
            }
        } while (indexLeft < leftMerge.length || indexRight < rightMerge.length);

        return finalData;

    }


    public int[] mergeSort(int[] array, int start, int end) {

        if (end - start == 1) {
            return null;
        }

        int i = (end - start) / 2;

        int[] leftDataMerge = mergeSort(array, start, start + i);
        int[] rightDataMerge = mergeSort(array, start + i, end);

        if (leftDataMerge == null) {
            leftDataMerge = Arrays.copyOfRange(array, start, start + i);
        }
        if (rightDataMerge == null) {
            rightDataMerge = Arrays.copyOfRange(array, start + i, end);

        }

        return mergeData(leftDataMerge, rightDataMerge);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] data = {1, 8, 10, 60, 5, 6, 7, 4, 3, 9, 0};
        int[] ints = mergeSort.mergeSort(data);
        System.out.println(Arrays.toString(ints));

        int[] dataBc = {1, 8, 10, 60, 5, 6, 7, 4, 3, 9, 0};
        int[] ints1 = mergeSort.mergeSort(dataBc, 0, dataBc.length);

        System.out.println(Arrays.toString(ints1));
    }

}
