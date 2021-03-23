package src.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// cycle detection in undirected graph using BFS
public class CycleDetectionBFS<T> extends src.Graphs.Graph<T> {
    public static void main(String[] args) {
        CycleDetectionBFS<Integer> g = new CycleDetectionBFS<>();
        g.addEdge(1, 2, true);
        g.addEdge(3, 2, true);
        g.addEdge(3, 4, true);
        g.addEdge(1, 4, true);
        System.out.println("Cycle present : " + g.isCyclic(1));
    }

    private boolean isCyclic(T src) {
        Queue<T> q = new LinkedList<>();
        HashMap<T, T> parent = new HashMap<>();
        ArrayList<T> visited = new ArrayList<>();
        q.add(src);
        visited.add(src);
        parent.put(src, src);
        while (!q.isEmpty()) {
            T node = q.poll();
            for (T neighbour : adjList.get(node)) {
                if (visited.contains(neighbour) && !parent.get(neighbour).equals(node))
                    return true;
                else if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parent.put(neighbour, node);
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
}
