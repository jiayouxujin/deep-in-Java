package com.xuxiaojin.algorithm;

public class ShortestCost2 {
    public static int findMin(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int N = cost.length;
        int[] lookup = new int[N];
        for (int i = 0; i < N; i++) {
            lookup[i] = cost[0][i];
        }

        boolean isFilled = false;
        while (!isFilled) {
            isFilled = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (lookup[i] > lookup[j] + cost[j][i]) {
                        lookup[i] = lookup[j] + cost[j][i];
                        isFilled = false;
                    }
                }
            }
        }

        return lookup[N - 1];
    }

    public static void main(String[] args) {
        int[][] cost = {
                {0, 25, 20, 10, 105},
                {20, 0, 15, 80, 80},
                {30, 15, 0, 70, 90},
                {10, 10, 50, 0, 100},
                {40, 50, 5, 10, 0}
        };

        System.out.println(findMin(cost));
    }
}
