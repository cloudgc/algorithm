package org.cloudfun.algorithm.sort;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/12
 */
public class RadixSort {

    public Integer[] radixSort(Integer[] arrays) {


        return null;
    }

    public Integer[] generateData(int length) {

        if (length > 32) {
            throw new IllegalArgumentException("length is to big");
        }

        Integer[] data = new Integer[length];
        for (int i = 0; i < length; i++) {
            double v = Math.round(Math.random() * (10 ^ length));
            data[i] = Double.valueOf(v).intValue();
        }
        return data;
    }


}
