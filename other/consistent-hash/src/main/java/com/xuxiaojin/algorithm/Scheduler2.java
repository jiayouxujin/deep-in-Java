package com.xuxiaojin.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler2 {
    static int[][] cost = {
            {9, 2, 7, 8},
            {6, 4, 3, 7},
            {5, 8, 1, 8},
            {7, 6, 9, 4}
    };

    //有问题
    private static int[] getByGreedy(int[][] cost) {
        int[] assign = new int[4];
        int res = 0;
        for (int i = 0; i < cost[0].length; i++) {
            int c = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < cost.length; j++) {
                if (c > cost[j][i] && assign[j] == 0) {
                    c = cost[j][i];
                    k = j;
                }
            }
            assign[k] = i;
            res += c;
        }

        return assign;
    }

    private static int[] getMinimum(int[][] cost) {
        int res = 0;
        int[] assign = new int[4];
        for (int i = 0; i < cost.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < cost[i].length; j++) {
                if (min > cost[i][j]) {
                    min = cost[i][j];
                    k = j;
                }
            }
            assign[i] = k;
            res += min;
        }
        return assign;
    }

    public static void main(String[] args) {
        int[] minimum = getMinimum(cost);
        int max = 14;

        Queue<Node> queue = new LinkedList<>();
        Node node1 = new Node(0, minimum[0], minimum[1], minimum[2], minimum[3]);
        System.out.println(node1);
        queue.add(node1);

        Node ans = null;
        int minCost = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.level == 0) {
                for (int i = 0; i < 4; i++) {
                    Node node = new Node(cur.level + 1, i, cur.tow, cur.three, cur.four);
                    int c = node.getCost();
                    if (c <= max) {
                        System.out.println("level 1 " + node);
                        queue.add(node);
                    }
                }
            } else if (cur.level == 1) {
                for (int i = 0; i < 4; i++) {
                    Node node = new Node(cur.level + 1, cur.one, i, cur.three, cur.four);
                    int c = node.getCost();
                    if (c <= max && i != cur.one) {
                        System.out.println("level 2 " + node);
                        queue.add(node);
                    }
                }
            } else if (cur.level == 2) {
                for (int i = 0; i < 4; i++) {
                    Node node = new Node(cur.level + 1, cur.one, cur.tow, i, cur.four);
                    int c = node.getCost();
                    if (c <= max && i != cur.one && i != cur.tow) {
                        System.out.println("level 3 " + node);
                        queue.add(node);
                    }
                }
            } else if (cur.level == 3) {
                for (int i = 0; i < 4; i++) {
                    Node node = new Node(cur.level + 1, cur.one, cur.tow, cur.three, i);
                    int c = node.getCost();
                    if (c <= max && i != cur.one && i != cur.tow && i != cur.three) {
                        System.out.println("level 4 " + node);
                        queue.add(node);
                    }
                }
            } else {
                int c = cur.getCost();
                if (minCost > c) {
                    minCost = c;
                    ans = cur;
                }
            }
        }
        System.out.println(ans);
    }

    private static class Node {
        public int level;
        public int one;
        public int tow;
        public int three;
        public int four;

        public Node(int level, int one, int tow, int three, int four) {
            this.level = level;
            this.one = one;
            this.tow = tow;
            this.three = three;
            this.four = four;
        }

        public int getCost() {
            return cost[0][one] + cost[1][tow] + cost[2][three] + cost[3][four];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "person 1 get task " + (one + 1) +
                    ", person 2 get task " + (tow + 1) +
                    ", person 3 get task " + (three + 1) +
                    ", person 4 get task " + (four + 1) +
                    ", cost =" + (cost[0][one] + cost[1][tow] + cost[2][three] + cost[3][four]) +
                    '}';
        }
    }
}
