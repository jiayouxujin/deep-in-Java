package com.xuxiaojin.algorithm;

public class HeapSort {
    static int[] array = {78, 52, 69, 84, 12, 35, 64, 85, 68};

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    private static void sort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;

            heapify(array, length, largest);
        }
    }


    public static void main(String[] args) {
        HeapSort.print(array);
        HeapSort.sort(array);
        HeapSort.print(array);
    }
}
