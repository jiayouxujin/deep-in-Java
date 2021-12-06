package com.xuxiaojin.algorithm;

public class MaxSubArray {

    private static void solve(int[] array) {
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                res[i] = Math.max(array[i], array[i] + res[i - 1]);
            } else {
                if (array[i] >= 0) {
                    res[i] = array[i];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(res[i]);
        }
        return;
    }

    public static void main(String[] args) {
        solve(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
    }
}
