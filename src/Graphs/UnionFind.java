package Graphs;

import java.util.Arrays;

// used to detect cycle in a graph
public class UnionFind {
    static class Edge {
        int src, dest;

        public Edge() {
        }

        void addEdge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    private Edge[] g;
    private int V, E;

    private void union(int[] parent, int x, int y) {
        int xp = findParent(x, parent);
        int yp = findParent(y, parent);
        parent[yp] = xp;
    }

    private int findParent(int node, int[] parent) {
        if (parent[node] == -1)
            return node;
        return findParent(parent[node], parent);
    }

    private boolean isCyclic() {
        int[] parent = new int[this.V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < this.E; i++) {
            int x = findParent(this.g[i].src, parent);
            int y = findParent(this.g[i].dest, parent);
            if (x == y) {
                return true;
            }
            union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        UnionFind f = new UnionFind();
        f.E = 4;
        f.V = 4;
        f.g = new Edge[f.E];
        for (int i = 0; i < f.E; i++)
            f.g[i] = new Edge();
        f.g[0].addEdge(0, 1);
        f.g[1].addEdge(1, 2);
        f.g[2].addEdge(3, 0);
        f.g[2].addEdge(2, 3);
        if (f.isCyclic()) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("No cycle found");
        }
    }
}
