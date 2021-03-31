package Graphs;

// Disjoint Set Union
// Union by rank with Path Compression
public class DSU {
    int V;
    int[] parent;
    int[] rank;

    public DSU(int n) {
        this.V = n;
        this.parent = new int[this.V];
        this.rank = new int[this.V];
        for (int i = 0; i < this.V; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] == -1)
            return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int n, int m) {
        int pn = find(n);
        int pm = find(m);
        if (pn != pm) {
            if (rank[pn] < rank[pm]) {
                parent[pn] = pm;
                rank[pm] += rank[pn];
            } else {
                parent[pm] = pn;
                rank[pn] += rank[pm];
            }
        }
    }
}