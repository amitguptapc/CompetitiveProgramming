import java.util.*;

public class DijkstraAlgo {
    private static void dijkstra(int n, ArrayList<Edge>[] adj, int src) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Edge(src, 0));
        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            int node = top.node;
            int dist = top.cost;
            for (Edge nbr : adj[node]) {
                if (dist + nbr.cost < distances[nbr.node]) {
                    pq.remove(new Edge(nbr.node, distances[nbr.node]));
                    distances[nbr.node] = dist + nbr.cost;
                    pq.add(new Edge(nbr.node, distances[nbr.node]));
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