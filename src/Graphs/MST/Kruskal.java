package Graphs.MST;

import Graphs.DSU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 Used for finding the minimum spanning tree (MST)
 MST is a tree covering all the vertices in minimum possible cost
 In Kruskal's Algorithm all the edges are sorted acc to their weights
 Edges of less weight are picked such that no cycle is formed
 and all the vertices are covered
 it is a greedy algorithm
 graph must be undirected and weighted
*/
public class Kruskal {
    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    private static int kruskal(Edge[] edgeList, int v) {
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o.weight));
        DSU s = new DSU(v);
        ArrayList<Edge> MST = new ArrayList<>();
        int ans = 0, x, y, w;
        for (Edge e : edgeList) {
            x = e.src;
            y = e.dest;
            w = e.weight;
            if (s.find(x) != s.find(y)) {
                s.union(x, y);
                MST.add(e);
                ans += w;
            }
        }
        for (Edge e : MST)
            System.out.println(e.src + " - " + e.dest + " weight " + e.weight);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++)
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(kruskal(edges, v));
    }
}
