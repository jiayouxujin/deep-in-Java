package com.xuxiaojin.algorithm;

public class MatrixChain {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        System.out.println(result(arr, 1, arr.length - 1));
    }

    //m[i,j]=min{m[i,k]+m[k+1,j]+p[i-1]*p[k]*p[j]
    private static int result(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = result(p, i, k) + result(p, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (min > cost) {
                min = cost;
            }
        }
        return min;
    }
}
