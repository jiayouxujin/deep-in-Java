package com.xuxiaojin.algorithm;

public class StampCost {
    private final static int MAX_NM = 10;
    private final static int MAX_POSTAGE = 1024;
    private final static int INF = Integer.MAX_VALUE;

    private int n;
    private int m;

    private int values[];
    private int stamps[];
    private int leastStamp[];
    private int maxStamp;
    private int range;

    public StampCost(int n, int m) {
        this.values = new int[MAX_NM];
        this.values[0] = 1;
        this.stamps = new int[MAX_NM];
        this.leastStamp = new int[MAX_POSTAGE];
        this.n = n;
        this.m = m;
        this.range = m;

        int i = 0;
        for (i = 0; i <= this.range; i++) {
            this.leastStamp[i] = i;
        }
        while (i < MAX_POSTAGE) {
            leastStamp[i++] = INF;
        }

        this.maxStamp = 0;
    }

    public void backtrack(int i) {
        int tmp;
        if (i >= this.n) {
            if (this.range > this.maxStamp) {
                this.maxStamp = this.range;
                for (tmp = 0; tmp < this.n; tmp++) {
                    this.stamps[tmp] = this.values[tmp];
                }
            }
            return;
        }

        int[] backupY = new int[MAX_POSTAGE];
        for (tmp = 0; tmp < MAX_POSTAGE; tmp++) {
            backupY[tmp] = this.leastStamp[tmp];
        }

        int backupR = this.range;

        int next;
        int postage;
        int num;

        for (next = values[i - 1] + 1; next <= range + 1; next++) {
            this.values[i] = next;
            for (postage = 0; postage < values[i - 1] * m; postage++) {
                for (num = 1; num <= this.m - this.leastStamp[postage]; num++) {
                    if (postage + num * next < MAX_POSTAGE && this.leastStamp[postage] + num < this.leastStamp[postage + num * next]) {
                        leastStamp[postage + num * next] = leastStamp[postage] + num;
                    }
                }
            }

            while (this.range + 1 < MAX_POSTAGE && this.leastStamp[this.range + 1] != INF) {
                this.range++;
            }

            backtrack(i + 1);
            this.range = backupR;
            for (tmp = 0; tmp < MAX_POSTAGE; tmp++) {
                this.leastStamp[tmp] = backupY[tmp];
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(stamps[i] + " ");
        }
        System.out.println(":" + this.maxStamp);
    }

    public static void main(String[] args) {
        StampCost stampCost = new StampCost(5, 4);
        stampCost.backtrack(1);
        stampCost.print();
    }
}
