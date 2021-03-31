package src.Graphs;

import java.util.Arrays;

// used to detect cycle in a graph
public class UnionFind {
    private Edge[] g;
    private int V, E;

    public static void main(String[] args) {
        UnionFind f = new UnionFind();
        f.E = 4;
        f.V = 4;
        f.g = new Edge[f.E];
        f.g[0] = new Edge(0, 1);
        f.g[1] = new Edge(1, 2);
        f.g[2] = new Edge(3, 0);
        f.g[2] = new Edge(2, 3);
        if (f.isCyclic()) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("No cycle found");
        }
    }

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

    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
}
