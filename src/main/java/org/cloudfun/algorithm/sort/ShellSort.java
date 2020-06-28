package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * @author 88447351
 * @apiNote
 * @date 2019/11/27
 * <blockquote><pre>
 *      最小增量插入 DiminishingIncrementSort
 * </pre></blockquote>
 * <p>
 * 原地排序 不稳定排序 时间复杂 最好O(n*log2n) 最坏O(N^2) 平均 O(n^3/2)
 * </P>
 */
public class ShellSort {
    
    
    static void ShellPass(int[] array) {
        int gap = array.length;
        do {
            //增量每次减半
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                //这个循环里其实就是一个插入排序
                for (int j = i + gap; j < array.length; j += gap) {
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
        } while (gap != 1);
    }
    
    
    public static void main(String[] args) {
        
        int[] data = new int[] {1, 3, 4, 2, 0};
        ShellPass(data);
        System.out.println(Arrays.toString(data));
        
        
    }
    
}
