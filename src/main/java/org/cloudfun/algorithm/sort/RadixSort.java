package org.cloudfun.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/12
 */
public class RadixSort {
    
    BucketSort bucketSort = new BucketSort();
    
    
    public Integer[] radixSort(Integer[] arrays, int start) {
        
        if (start >= 10 || arrays.length <= 1) {
            return arrays;
        }
        
        int bucketLength = 1;
        
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= 10; i += bucketLength) {
            buckets.add(new ArrayList<>());
        }
        
        for (Integer ele : arrays) {
            int bucketIndex = Integer.parseInt(Integer.toString(ele).substring(start, start + 1));
            buckets.get(bucketIndex).add(ele);
        }
        
        List<Integer> data = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            Integer[] buks = new Integer[bucket.size()];
            Integer[] integers = radixSort(bucket.toArray(buks), start + 1);
            data.addAll(Arrays.asList(integers));
        }
        
        Integer[] dataList = new Integer[data.size()];
        return data.toArray(dataList);
    }
    
    public Integer[] generateData(int length) {
        
        if (length > (100000000)) {
            throw new IllegalArgumentException("length is to big");
        }
        
        Integer[] data = new Integer[length];
        for (int i = 0; i < length; i++) {
            double v = Math.round(Math.random() * (1000000000));
            data[i] = Double.valueOf(v).intValue();
        }
        return data;
    }
    
    
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        Integer[] integers = radixSort.generateData(10);
        System.out.println(Arrays.toString(integers));
        
        Integer[] integers1 = radixSort.radixSort(integers, 0);
        System.out.println(Arrays.toString(integers1));
        
    }
}
