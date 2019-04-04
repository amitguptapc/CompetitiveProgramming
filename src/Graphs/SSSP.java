package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SSSP<T> extends Graph<T> {
    // Single source shortest path using bfs for unweighted graph
    public void sssp(T src) {
        Queue<T> q = new LinkedList<>();
        Map<T, Integer> distance = new HashMap<>();
        for (T node : adjList.keySet())
            distance.put(node, Integer.MAX_VALUE);
        q.add(src);
        distance.put(src, 0);
        while (!q.isEmpty()) {
            T node = q.poll();
            for (T neighbour : adjList.get(node)) {
                if (distance.get(neighbour) == Integer.MAX_VALUE) {
                    q.add(neighbour);
                    distance.put(neighbour, distance.get(node) + 1);
                }
            }
        }
        for (T val : adjList.keySet()) {
            System.out.println("Distance of " + val + " from " + src + " is " + distance.get(val));
        }
    }

    public static void main(String[] args) {
        SSSP<Integer> g = new SSSP<>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        System.out.println("Adjacency List : ");
        g.printAdjList();
        System.out.println("Single Source Shortest Path : ");
        g.sssp(0);
    }
}