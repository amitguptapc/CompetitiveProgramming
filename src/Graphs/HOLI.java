package Graphs;

//https://www.spoj.com/problems/HOLI/
// (Holiday Accommodation) it requires application of  Pigeonhole principle

import java.util.ArrayList;
import java.util.Scanner;

class Edge {
    public int destination;
    public int weight;

    public Edge(int d, int c) {
        destination = d;
        weight = c;
    }
}

class City {
    public int V;
    public ArrayList<ArrayList<Edge>> l;
    public int ans;

    City(int v) {
        V = v;
        l = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            l.add(i, new ArrayList<>());
        }
        ans = 0;
    }

    public void addEdge(int u, int v, int cost) {
        ArrayList<Edge> l1 = l.get(u);
        l1.add(u, new Edge(v, cost));
        l.add(u, l1);
        ArrayList<Edge> l2 = l.get(v);
        l2.add(v, new Edge(u, cost));
        l.add(v, l2);
    }

    // to find size of subtree
    public int dfsHelper(int node, int[] count, boolean[] visited) {
        visited[node] = true;
        count[node] = 1;
        for (Edge neighbour : l.get(node)) {
            int v = neighbour.destination;
            if (!visited[v]) {
                count[node] += dfsHelper(v, count, visited);
                ans += 2 * Math.min(count[v], V - count[v]) * neighbour.weight;
            }
        }
        return count[node];
    }

    public void dfs() {
        boolean[] visited = new boolean[V];
        int[] count = new int[V];
        dfsHelper(0, count, visited);
    }
}

public class HOLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            City g = new City(n);
            for (int i = 0; i < n - 1; i++)
                g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
            g.dfs();
            System.out.println(g.ans);
            t--;
        }
    }
}