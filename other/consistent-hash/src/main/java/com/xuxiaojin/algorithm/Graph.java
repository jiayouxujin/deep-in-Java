package com.xuxiaojin.algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    public int V;
    public LinkedList<Integer> adj[];

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void color() {
        int[] result = new int[V];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean[] available = new boolean[V];
        Arrays.fill(available, true);

        for (int u = 1; u < V; u++) {
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }

            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr;
            Arrays.fill(available, true);
        }

        // print the result
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);
    }

    public static void main(String args[])
    {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.color();
    }
}
