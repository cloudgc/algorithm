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
        innerArray = new int[capacity];
        maxLength = capacity;
        count = -1;
    }

    /**
     * @param ele add element
     */
    public void addElement(int ele) {
        if (count + 1 >= maxLength) {
            return;
        }
        ++count;
        innerArray[count] = ele;

        int i = count;
        while ((i + 1) / 2 > 0 && innerArray[i] > innerArray[(i - 1) / 2]) {
            swap(innerArray, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * swap one & other position
     *
     * @param innerArray array
     * @param i          one
     * @param j          other
     */
    private void swap(int[] innerArray, int i, int j) {
        int tmp = innerArray[i];
        innerArray[i] = innerArray[j];
        innerArray[j] = tmp;
    }

    /**
     * remove top of heap element
     * 交换到最后一个元素然后 建堆
     */
    public void removeMaxElement() {
        swap(innerArray, 0, count);
        innerArray[count] = 0;
        --count;
        heapify(innerArray, count, 0);


    }

    /**
     * 堆化 某个元素
     *
     * @param innerArray array
     * @param count      array current count
     * @param i          start position
     */
    private void heapify(int[] innerArray, int count, int i) {
        while (true) {
            int maxPos = i;

            if ((i + 1) * 2 - 1 <= count && innerArray[i] < innerArray[(i + 1) * 2 - 1]) {
                maxPos = (i + 1) * 2 - 1;
            }
            if ((i + 1) * 2 < count && innerArray[i] < innerArray[(i + 1) * 2]) {
                maxPos = (i + 1) * 2;
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


    public Heap buildHeap(int[] array) {


        return this;
    }

    public void sort() {

    }


    public static void main(String[] args) {
        Heap heap = new Heap(5);

        for (int i = 1; i < 6; i++) {
            heap.addElement(i);
        }

        heap.print();


        heap.removeMaxElement();

        heap.print();

        heap.removeMaxElement();

        heap.print();


    }


}
