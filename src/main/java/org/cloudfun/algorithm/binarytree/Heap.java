package org.cloudfun.algorithm.binarytree;

import java.util.Arrays;

import static org.cloudfun.algorithm.binarytree.BinaryTree.*;

/**
 * @author cloudgc
 */
public class Heap {

    /**
     * 内部数组
     */
    private int[] innerArray;

    /**
     * 最大数值长度
     */
    private int maxLength;

    /**
     * current heap element
     */
    private int count;

    public int[] getInnerArray() {
        return innerArray;
    }

    public Heap(int capacity) {
        innerArray = new int[capacity + 1];
        maxLength = capacity;
        count = 0;
    }

    public void addElement(int ele) {
        if (count >= maxLength) {
            return;
        }
        ++count;
        innerArray[count] = ele;

        int i = count;
        while (i / 2 > 0 && innerArray[i] > innerArray[i / 2]) {
            swap(innerArray, i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int[] innerArray, int i, int j) {
        int tmp = innerArray[i];
        innerArray[i] = innerArray[j];
        innerArray[j] = tmp;
    }

    public void removeMaxElement() {
        swap(innerArray, 1, count);
        innerArray[count] = 0;
        --count;
        heapify(innerArray, count, 1);


    }

    private void heapify(int[] innerArray, int t, int i) {
        while (true) {
            int maxPos = i;

            if (i * 2 <= t && innerArray[i] < innerArray[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 < t && innerArray[i] < innerArray[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }

            swap(innerArray, i, maxPos);
            i = maxPos;

        }

    }

    public void print() {

        System.out.println(Arrays.toString(this.getInnerArray()));
    }


    public static void main(String[] args) {
        Heap heap = new Heap(5);

        for (int i = 1; i <= 5; i++) {
            heap.addElement(i);
        }

        heap.print();


        heap.removeMaxElement();

        heap.print();


    }


}
