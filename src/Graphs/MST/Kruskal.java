package Graphs.MST;

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

    static class Set {
        int parent;
        int rank;

        Set(int p, int r) {
            parent = p;
            rank = r;
        }
    }

    private static void union(Set[] list, int x, int y) {
        int xp = find(x, list);
        int yp = find(y, list);
        if (list[xp].rank > list[yp].rank)
            list[yp].parent = xp;
        else if (list[xp].rank < list[yp].rank)
            list[xp].parent = yp;
        else {
            list[xp].parent = yp;
            list[yp].rank++;
        }
    }

    private static int find(int node, Set[] list) {
        if (list[node].parent != node)
            list[node].parent = find(list[node].parent, list);
        return list[node].parent;
    }

    private static void kruskal(Edge[] edges, int v, int e) {
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        Edge[] mst = new Edge[v - 1];
        Set[] list = new Set[v];
        for (int i = 0; i < v; i++)
            list[i] = new Set(i, 0);
        int count = 0, i = 0;
        while (count < v - 1) {
            Edge current = edges[i++];
            int srcP = find(current.src, list);
            int destP = find(current.dest, list);
            if (srcP != destP) {
                union(list, srcP, destP);
                mst[count++] = current;
            }
        }
        for (int j = 0; j < v - 1; j++)
            System.out.println(mst[j].src + " - " + mst[j].dest + " with weight " + mst[j].weight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++)
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        kruskal(edges, v, e);
    }
}
