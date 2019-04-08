package src.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph<T> {
    public Map<T, LinkedList<T>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(T u, T v, boolean isBiDir) {
        LinkedList<T> l1;

        if (!adjList.containsKey(u)) {
            l1 = new LinkedList<>();
            adjList.put(u, l1);
        } else
            l1 = adjList.get(u);

        l1.add(v);


        if (isBiDir) {
            if (!adjList.containsKey(v)) {
                l1 = new LinkedList<>();
                adjList.put(v, l1);
            } else
                l1 = adjList.get(v);

            l1.add(u);
        }
        if (!adjList.containsKey(v)) {
            adjList.put(v, new LinkedList<>());
        }
    }

    public void printAdjList() {
        for (T val : adjList.keySet()) {
            System.out.print(val + " -> ");
            for (T val1 : adjList.get(val)) {
                System.out.print(val1 + " ");
            }
            System.out.println();
        }
    }
}