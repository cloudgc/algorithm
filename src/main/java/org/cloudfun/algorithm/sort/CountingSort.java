package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/12
 * <p>
 * 计数排序
 * </p>
 */
public class CountingSort {
    
    
    public int[] countIngSort(int[] array) {
        
        int maxNum = 150;
        // int bucketLength = 15;
        // int bucketNum = maxNum / bucketLength;
        
        int[] container = new int[maxNum];
        
        // put ele num
        for (int ele : array) {
            container[ele]++;
        }
        
        // counting before ele position
        for (int i = 1; i < container.length; i++) {
            container[i] = container[i] + container[i - 1];
        }
        
        int[] data = new int[array.length];
        
        for (int ele : array) {
            data[container[ele] - 1] = ele;
            container[ele]--;
        }
        
        return data;
    }
    
    
    public static void main(String[] args) {
        int[] data = {10, 60, 77, 89, 6, 70, 60, 23, 45, 55, 72, 18, 67, 34};
        
        CountingSort countingSort = new CountingSort();
        
        int[] ints = countingSort.countIngSort(data);
        
        System.out.println(Arrays.toString(ints));
        
    }
    
}
