package com.xuxiaojin.algorithm;

public class RadixSort {
    static int[] array = {78, 52, 69, 84, 12, 35, 64, 85, 68};

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void radixSort(int[] array) {
        int d = 100, n = 1, k = 0;
        int[][] bucket = new int[10][array.length];
        int[] order = new int[10];

        while (d > n) {
            for (int i = 0; i < array.length; i++) {
                int digit = (array[i] / n) % 10;
                bucket[digit][order[digit]] = array[i];
                order[digit]++;
            }

            for (int i = 0; i < order.length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                    order[i] = 0;
                }
            }
            n *= 10;
            k = 0;
        }
    }

    public static void main(String[] args) {
        RadixSort.print(array);
        RadixSort.radixSort(array);
        RadixSort.print(array);

    }
}
