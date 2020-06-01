package org.cloudfun.algorithm.binarytree;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cloudgc
 *
 * <p>
 * i 的 第一个子节点： (i + 1) * 2 - 1
 * i 的 父节点  (i - 1) / 2
 * </p>
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
        extendArray(new int[capacity], capacity, -1);
    }

    public Heap() {
    }

    public Heap(int[] array) {
        extendArray(array, array.length, array.length - 1);
    }

    private void extendArray(int[] array, int length, int i) {
        innerArray = array;
        maxLength = length;
        count = i;
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

            if ((i + 1) * 2 <= count && innerArray[maxPos] < innerArray[(i + 1) * 2]) {
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


    public Heap buildHeap() {
        for (int i = (count + 1) / 2 - 1; i >= 0; --i) {
            heapify(innerArray, count, i);
        }

        return this;
    }

    public void sort() {
        int k = 0;
        while (k <= count) {
            swap(innerArray, 0, count - k);
            ++k;
            heapify(innerArray, count - k, 0);
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap(100);

        Random random = new Random();

        for (int i = 1; i < 100; i++) {
            heap.addElement(random.nextInt(100) + 1);
        }
        // Heap heap = new Heap(10);
        // int[] ints = {96, 68, 93, 44, 34, 61, 83, 15, 12, 21};
        // for (int i : ints) {
        //     heap.addElement(i);
        // }

        heap.print();
        heap.removeMaxElement();

        heap.print();

        heap.removeMaxElement();

        heap.print();

        heap.buildHeap();
        heap.sort();
        heap.print();

    }


}
