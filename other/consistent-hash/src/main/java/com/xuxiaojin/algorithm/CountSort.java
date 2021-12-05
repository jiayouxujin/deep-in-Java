package com.xuxiaojin.algorithm;

public class CountSort {
    static int[] array = {78, 52, 69, 84, 12, 35, 64, 85, 68};

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void sort(int[] array) {
        int maxValue = findMax(array);
        int[] order = new int[maxValue + 1];

        for (int i = 0; i < array.length; i++) {
            order[array[i]] += 1;
        }

        int k = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (order[i] > 0) {
                array[k] = i;
                k++;
                order[i]--;
            }
        }
    }

    private static int findMax(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = Math.max(array[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        CountSort.print(array);
        CountSort.sort(array);
        CountSort.print(array);
    }
}
