import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// Greedy algorithm
// works for undirected, weighted and connected graph
public class Prim {
    static class Graph {
        static class Edge {
            int dest;
            int weight;

            Edge(int a, int b) {
                dest = a;
                weight = b;
            }
        }

        static class Path { // this class is needed when we need to print MST along with cost
            int src;
            int dest;
            int weight;

            Path(int a, int b, int c) {
                src = a;
                dest = b;
                weight = c;
            }
        }

        private int v;
        private ArrayList<Edge>[] adjList;

        Graph(int v) {
            this.v = v;
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++)
                adjList[i] = new ArrayList<>();
        }

        public void addEdge(int u, int v, int w) {
            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        public int prim() {
            PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            ArrayList<Path> MST = new ArrayList<>();
            boolean[] visited = new boolean[v];
            int mstCost = 0;
            pq.add(new Path(0, 0, 0));
            while (!pq.isEmpty()) {
                Path mini = pq.poll();
                int dest = mini.dest;
                int weight = mini.weight;

                if (visited[dest])
                    continue;

                mstCost += weight;
                MST.add(mini);
                visited[dest] = true;

                for (Edge nbr : adjList[dest]) {
                    if (!visited[nbr.dest])
                        pq.add(new Path(dest, nbr.dest, nbr.weight));
                }
            }

            for (Path p : MST)
                System.out.println(p.src + " - " + p.dest + " weight " + p.weight);
            return mstCost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(v);
        while (e-- > 0) {
            g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.println(g.prim());
    }
}
/*
Sample Test Case
7 8
0 3 4
0 1 6
1 2 5
3 2 7
3 4 2
4 5 4
5 6 1
4 6 3
 */