import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class DijkstraAlgo {
    private static void dijkstra(int n, ArrayList<Edge>[] adj, int src) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        TreeSet<Edge> set = new TreeSet<Edge>((o1, o2) -> o1.cost - o2.cost);
        set.add(new Edge(src, 0));
        while (!set.isEmpty()) {
            Edge e = set.pollFirst();
            int node = e.node;
            int dist = e.cost;
            for (Edge ed : adj[node]) {
                if (dist + ed.cost < distances[ed.node]) {
                    distances[ed.node] = dist + ed.cost;
                    set.remove(new Edge(ed.node, distances[ed.node]));
                    set.add(new Edge(ed.node, distances[ed.node]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != src) {
                if (distances[i] != Integer.MAX_VALUE)
                    System.out.print(distances[i] + " ");
                else System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Edge>[] adjList = new ArrayList[n];
            for (int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();
            int u, v, d;
            for (int i = 0; i < m; i++) {
                u = sc.nextInt() - 1;
                v = sc.nextInt() - 1;
                d = sc.nextInt();
                adjList[u].add(new Edge(v, d));
                adjList[v].add(new Edge(u, d));
            }
            int s = sc.nextInt() - 1;
            dijkstra(n, adjList, s);
        }
    }

    static class Edge {
        int node;
        int cost;

        Edge(int d, int c) {
            node = d;
            cost = c;
        }
    }
}