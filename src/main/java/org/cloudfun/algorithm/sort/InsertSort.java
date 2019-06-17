package org.cloudfun.algorithm.sort;

import java.util.Arrays;

/**
 * Copyright @ 2019/6/12
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class InsertSort {

    static class NormalInsertSort {

        static int[] sort(int[] data) {

            if (data == null || data.length <= 0) {
                return data;
            }

            for (int i = 1; i < data.length; i++) {
                int e = data[i];
                int j = i - 1;
                for (; j >= 0; --j) {
                    if (e < data[j]) {
                        data[j + 1] = data[j];
                    } else {
                        break;
                    }

                }
                System.out.println("j:"+j);
                data[j + 1] = e;

            }

            return data;
        }

        public static void main(String[] args) {

            int[] data = new int[]{1,3,4,2};
            int[] sort = NormalInsertSort.sort(data);
            System.out.println(Arrays.toString(sort));
        }

    }
}
