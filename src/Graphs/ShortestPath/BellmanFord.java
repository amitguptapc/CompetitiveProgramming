package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Complexity O(VE)
public class BellmanFord {
    private static final int INFINITY = Integer.MAX_VALUE;

    static class Edge<T> {
        T src, dest;
        int weight;

        Edge(T u, T v, int weight) {
            src = u;
            dest = v;
            this.weight = weight;
        }
    }

    static class Graph<T> {
        int v, e;
        ArrayList<Edge<T>> edges;
        HashSet<T> vertices;

        Graph(int v, int e) {
            this.v = v;
            this.e = e;
            edges = new ArrayList<>();
            vertices = new HashSet<>();
        }

        void addEdge(T u, T v, int weight) {
            edges.add(new Edge<T>(u, v, weight));
            vertices.add(u);
            vertices.add(v);
        }

        void bellmanFord(T src) {
            HashMap<T, Integer> distances = new HashMap<>();
            for (T node : vertices) {
                if (node.equals(src))
                    distances.put(node, 0);
                else distances.put(node, INFINITY);
            }
            // Relaxation phase
            for (int i = 1; i < v; i++) {
                for (Edge<T> e : edges) {
                    T source = e.src;
                    T dest = e.dest;
                    int weight = e.weight;
                    if (distances.get(source) != INFINITY && distances.get(source) + weight < distances.get(dest))
                        distances.put(dest, distances.get(source) + weight);
                }
            }
            // Check for negative weight cycle
            for (Edge<T> e : edges) {
                T source = e.src;
                T dest = e.src;
                int weight = e.weight;
                if (distances.get(source) != INFINITY && distances.get(source) + weight < distances.get(dest)) {
                    System.out.println("Graph has negative weight cycle.");
                    return;
                }
            }
            for (T node : distances.keySet())
                System.out.println(node + " - " + distances.get(node));
        }
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(6, 7);
        g.addEdge("Amritsar", "Delhi", 1);
        g.addEdge("Amritsar", "Jaipur", 4);
        g.addEdge("Jaipur", "Delhi", 2);
        g.addEdge("Jaipur", "Mumbai", 8);
        g.addEdge("Bhopal", "Agra", 2);
        g.addEdge("Mumbai", "Bhopal", 3);
        g.addEdge("Agra", "Delhi", 1);
        g.bellmanFord("Amritsar");
    }
}