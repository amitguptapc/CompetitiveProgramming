import java.util.*;

public class ShortestPath {
    static class Graph {
        private int n;
        public Map<Integer, LinkedList<Integer>> adjList;

        public Graph(int n) {
            this.n = n;
            adjList = new HashMap<>();
            for (int i = 1; i <= n; i++)
                this.adjList.put(i, new LinkedList<>());
        }

        public void addEdge(int u, int v) {
            LinkedList<Integer> l1 = adjList.get(u);
            l1.add(v);
            l1 = adjList.get(v);
            l1.add(u);
        }

        void sssp(Integer src) {
            Queue<Integer> q = new LinkedList<>();
            Map<Integer, Integer> distance = new HashMap<>();
            for (int i = 1; i <= n; i++)
                distance.put(i, -1);
            q.add(src);
            distance.put(src, 0);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbour : adjList.get(node)) {
                    if (distance.get(neighbour) == -1) {
                        q.add(neighbour);
                        distance.put(neighbour, distance.get(node) + 6);
                    }
                }
            }
            for (int val : distance.keySet()) {
                if (val != src)
                    System.out.print(distance.get(val) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Graph g = new Graph(n);
            while (m-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                g.addEdge(u, v);
            }
            int s = sc.nextInt();
            g.sssp(s);
        }
    }
}