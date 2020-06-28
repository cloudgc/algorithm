package org.cloudfun.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/12
 * <p>
 * 数据必须是有限次的范围 可以分为有限次的桶
 * </p>
 */
public class BucketSort {
    
    /**
     * @param array data
     * @return sort data
     */
    public int[] BucketSort(int[] array) {
        
        int bucketLength = 150 / 10;
        
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= 150; i += bucketLength) {
            buckets.add(new ArrayList<>());
        }
        
        for (int ele : array) {
            int bucketIndex = ele / bucketLength;
            buckets.get(bucketIndex).add(ele);
        }
        
        for (List<Integer> bucket : buckets) {
            Integer[] bucketArray = new Integer[bucket.size()];
            Integer[] objects = bucket.toArray(bucketArray);
            if (objects.length == 0) {
                continue;
            }
            Integer[] arrayBucket = quickSort(objects, 0, bucketArray.length);
            bucket.clear();
            bucket.addAll(Arrays.asList(arrayBucket));
        }
        
        int[] finalData = new int[array.length];
        
        int startPos = 0;
        for (List<Integer> bucket : buckets) {
            Integer[] bucketArray = new Integer[bucket.size()];
            Integer[] objects = bucket.toArray(bucketArray);
            
            for (Integer ele : objects) {
                finalData[startPos] = ele;
                startPos++;
            }
        }
        
        return finalData;
    }
    
    
    /**
     * use left pivot
     *
     * @param array data
     * @param start start index
     * @param end   end index
     * @return final sort data
     */
    public Integer[] quickSort(Integer[] array, int start, int end) {
        
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
    
    
    public static void main(String[] args) {
        
        int[] data = {10, 60, 77, 89, 6, 70, 60, 23, 45, 55, 72, 18, 67, 34};
        
        BucketSort bucketSort = new BucketSort();
        int[] ints = bucketSort.BucketSort(data);
        System.out.println(Arrays.toString(ints));
        
    }
    
    
}
