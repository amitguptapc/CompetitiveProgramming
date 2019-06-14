package Graphs.StronglyConnectedComponent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// check whether a graph is strongly connected or not
public class Kosaraju {
    static class Graph {
        private int n;
        public Map<Integer, LinkedList<Integer>> adjList;

        Graph(int n) {
            this.n = n;
            adjList = new HashMap<>();
            for (int i = 1; i <= n; i++)
                this.adjList.put(i, new LinkedList<>());
        }

        public void addEdge(int u, int v) {
            LinkedList<Integer> l1;
            if (!adjList.containsKey(u)) {
                l1 = new LinkedList<>();
                adjList.put(u, l1);
            } else
                l1 = adjList.get(u);
            l1.add(v);
            if (!adjList.containsKey(v)) {
                adjList.put(v, new LinkedList<>());
            }
        }

        Graph transpose() {
            Graph g = new Graph(n);
            for (int node : adjList.keySet()) {
                for (int node1 : adjList.get(node)) {
                    g.addEdge(node1, node);
                }
            }
            return g;
        }

        void dfs(int node, boolean[] visited) {
            visited[node] = true;
            for (int neighbour : adjList.get(node)) {
                if (!visited[neighbour])
                    dfs(neighbour, visited);
            }
        }

        boolean isStronglyConnected() {
            boolean[] visited = new boolean[n];
            dfs(0, visited);
            // check all vertices are visited or not
            for (int i = 0; i < n; i++)
                if (!visited[i])
                    return false;
            // create transpose of the graph
            Graph g = transpose();
            visited = new boolean[n];
            g.dfs(0, visited);
            for (int i = 0; i < n; i++)
                if (!visited[i])
                    return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
//        g.addEdge(4, 2);
        System.out.println(g.isStronglyConnected());
    }
}
