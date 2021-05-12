package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

// Finds all the articulation points(cut vertices) in an undirected graph
// Complexity O(V+E)
public class ArticulationPoint {
    int v;
    int time;
    int[] low;
    int[] discovery;
    int[] parent;
    boolean[] AP;
    LinkedList<Integer>[] adjList;

    ArticulationPoint(int v) {
        this.v = v;
        time = 0;
        low = new int[v];
        parent = new int[v];
        discovery = new int[v];
        AP = new boolean[v];
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

    void AP(int u) {
        discovery[u] = time;
        low[u] = time;
        time++;
        int children = 0;
        for (int nbr : adjList[u]) {
            if (discovery[nbr] == -1) {
                children++;
                parent[nbr] = u;
                AP(nbr);
                low[u] = Math.min(low[u], low[nbr]);
                if (parent[u] == -1 && children > 1) // case 1, when u is root and children > 1
                    AP[u] = true;
                if (parent[u] != -1 && low[nbr] > discovery[u]) // case 2, when there is no back edge to ancestor of u
                    AP[u] = true;
            } else if (nbr != parent[u]) // to avoid child to parent edge
                low[u] = Math.min(low[u], discovery[nbr]);
        }
    }

    void findAP() {
        for (int i = 0; i < v; i++)
            if (discovery[i] == -1)
                AP(i);
        System.out.println("Articulation Points are :");
        for (int i = 0; i < v; i++)
            if (AP[i]) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        ArticulationPoint g = new ArticulationPoint(5);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.findAP();
    }
}