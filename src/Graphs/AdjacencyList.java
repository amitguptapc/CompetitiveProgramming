package src.Graphs;

import java.util.LinkedList;

// Adjacency List implementation of Graph for nodes with integer values

@SuppressWarnings("ALL")
class Graph1 {
    private int V;
    private LinkedList<Integer>[] l;

    public Graph1(int v) {
        V = v;
        l = new LinkedList[V];
        for (int i = 0; i < V; i++)
            l[i] = new LinkedList<Integer>();
    }

    public void addEdge(int u, int v, boolean isBidirectional) {
        l[u].add(v);
        if (isBidirectional)
            l[v].add(u);
    }

    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int v : l[i])
                System.out.print(v + ",");
            System.out.println();
        }
    }
}

public class AdjacencyList {
    public static void main(String[] args) {
        Graph1 g = new Graph1(5);
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        g.printAdjList();
    }
}