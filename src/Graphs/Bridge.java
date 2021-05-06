package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

// Finds all the bridges in an undirected graph
// Complexity O(V+E)
public class Bridge {
    int v;
    int time;
    int[] low;
    int[] discovery;
    int[] parent;
    LinkedList<Integer>[] adjList;

    Bridge(int v) {
        this.v = v;
        time = 0;
        low = new int[v];
        parent = new int[v];
        discovery = new int[v];
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
        Arrays.fill(low, -1);
        Arrays.fill(discovery, -1);
        Arrays.fill(parent, -1);
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void bridge(int u) {
        discovery[u] = time;
        low[u] = time;
        time++;
        for (int nbr : adjList[u]) {
            if (discovery[nbr] == -1) {
                parent[nbr] = u;
                bridge(nbr);
                low[u] = Math.min(low[u], low[nbr]);
                if (low[nbr] > discovery[u])
                    System.out.println(u + " - " + nbr);
            } else if (nbr != parent[u]) // ignore child to parent edge
                low[u] = Math.min(low[u], discovery[nbr]);
        }
    }

    void findBridge() {
        System.out.println("Bridges are :");
        for (int i = 0; i < v; i++)
            if (discovery[i] == -1)
                bridge(i);
    }

    public static void main(String[] args) {
        Bridge g = new Bridge(5);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.findBridge();
    }
}