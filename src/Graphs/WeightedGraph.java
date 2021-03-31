package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
    static class Edge<T> {
        public T dest;
        public int weight;

        public Edge(T d, int w) {
            this.dest = d;
            this.weight = w;
        }
    }

    public Map<T, List<Edge<T>>> adjList;

    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    public void addEdge(T u, T v, int weight) {
        if (!adjList.containsKey(u))
            adjList.put(u, new ArrayList<>());
        List<Edge<T>> l = adjList.get(u);
        l.add(new Edge<>(v, weight));
        if (!adjList.containsKey(v))
            adjList.put(v, new ArrayList<>());
    }

    public void printAdjList() {
        for (T u : adjList.keySet()) {
            System.out.print(u + " -> ");
            for (Edge<T> v : adjList.get(u))
                System.out.print("(" + v.dest + "," + v.weight + ") ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.addEdge(100, 199, 10);
        g.addEdge(100, 512, -100);
        g.addEdge(90, 100, 11);
        g.addEdge(199, 512, 20);
        g.addEdge(512, 199, 100);
        g.addEdge(90, 153, -90);
        g.addEdge(153, 90, 22);
        g.addEdge(512, 153, 40);
        g.printAdjList();
    }
}