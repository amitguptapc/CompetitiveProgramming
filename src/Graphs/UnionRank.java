package src.Graphs;

// used to detect cycle in a graph
public class UnionRank {
    private Edge[] g;
    private int V, E;

    public static void main(String[] args) {
        UnionRank f = new UnionRank();
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

    private void union(Prank[] list, int x, int y) {
        int xp = findParent(x, list);
        int yp = findParent(y, list);
        // add smaller rank under larger rank
        if (list[xp].rank > list[yp].rank)
            list[yp].parent = xp;
        else if (list[xp].rank < list[yp].rank)
            list[xp].parent = yp;
        else { // both having same rank
            list[xp].parent = yp;
            list[yp].rank++;
        }
    }

    private int findParent(int node, Prank[] list) {
        if (list[node].parent != node)
            list[node].parent = findParent(list[node].parent, list);
        return list[node].parent;
    }

    private boolean isCyclic() {
        Prank[] list = new Prank[this.V];
        for (int i = 0; i < this.V; i++)
            list[i] = new Prank(i, 0);
        for (int i = 0; i < this.E; i++) {
            int x = findParent(this.g[i].src, list);
            int y = findParent(this.g[i].dest, list);
            if (x == y) {
                return true;
            }
            union(list, x, y);
        }
        return false;
    }

    static class Edge {
        int src, dest;

        void addEdge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static class Prank {
        int parent;
        int rank;

        Prank(int p, int r) {
            parent = p;
            rank = r;
        }
    }
}
