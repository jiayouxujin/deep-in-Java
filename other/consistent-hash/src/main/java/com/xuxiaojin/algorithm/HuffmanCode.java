package com.xuxiaojin.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {

    static class HuffmanNode {
        public int item;
        public char c;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(int item, char c, HuffmanNode left, HuffmanNode right) {
            this.item = item;
            this.c = c;
            this.left = left;
            this.right = right;
        }
    }

    static class ImplementComparator implements Comparator<HuffmanNode> {

        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.item - o2.item;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[] charArray = {'A', 'B', 'C', 'D'};
        int[] charFreq = {5, 3, 7, 2};

        HuffmanNode root = null;
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new ImplementComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode(charFreq[i], charArray[i], null, null);
            q.add(node);
        }

        while (q.size() > 1) {
            HuffmanNode node1 = q.poll();
            HuffmanNode node2 = q.poll();

            HuffmanNode f = new HuffmanNode(node1.item + node2.item, '-', node1, node2);
            root = f;
            q.add(f);
        }

        System.out.println(" Char | Huffman Code");
        System.out.println("--------------------");
        printCode(root, "");
    }

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + "   |     " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
