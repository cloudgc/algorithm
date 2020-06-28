package org.cloudfun.algorithm.sort;

/**
 * 堆排序
 */
public class HeapSort {
    
    
    static class Heapify {
        
        private int[] a; // 数组，从下标 0 开始存储数据
        
        private int n;  // 堆可以存储的最大数据个数
        
        private int count; // 堆中已经存储的数据个数
        
        public Heapify(int capacity) {
            a = new int[capacity];
            n = capacity;
            count = 0;
        }
        
        public void addElement(int ele) {
            if (this.count >= n) {
                return;
            }
            ++count;
            a[count - 1] = ele;
            // 自下向上堆化
            //            while
            
        }
        
    }
    
}
