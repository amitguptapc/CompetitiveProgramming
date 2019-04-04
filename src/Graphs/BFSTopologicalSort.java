package Graphs;

// Topological Sort using BFS is done using Kahn's Algorithm

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTopologicalSort<T> extends Graph<T> {
    public void bfsTopologicalSort() {
        Queue<T> q = new LinkedList<>();
        HashMap<T, Integer> inDegree = new HashMap<>();

        for (T node : adjList.keySet()) {
            inDegree.put(node, 0);
        }

        // fill the in degrees of all nodes
        for (T node : adjList.keySet()) {
            for (T node1 : adjList.get(node)) {
                if (adjList.keySet().contains(node1))
                    inDegree.put(node1, inDegree.get(node1) + 1);
                else
                    inDegree.put(node1, 0);
            }
        }

        // find out all nodes with zero in degree
        for (T node : adjList.keySet()) {
            if (inDegree.get(node) == 0)
                q.add(node);
        }

        while (!q.isEmpty()) {
            T node = q.poll();
            System.out.print(node + "  -> ");
                for (T neighbour : adjList.get(node)) {
                    inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                    if (inDegree.get(neighbour) == 0)
                        q.add(neighbour);
                }
        }
    }

    public static void main(String[] args) {
        BFSTopologicalSort<String> g = new BFSTopologicalSort<>();
        g.addEdge("English", "Programming Language", false);
        g.addEdge("Maths", "Programming Language", false);
        g.addEdge("Programming Language", "HTML", false);
        g.addEdge("Programming Language", "Python", false);
        g.addEdge("Programming Language", "JAVA", false);
        g.addEdge("Programming Language", "JS", false);
        g.addEdge("Python", "Web Dev", false);
        g.addEdge("JS", "Web Dev", false);
        g.addEdge("JAVA", "Web Dev", false);
        g.addEdge("HTML", "CSS", false);
        g.addEdge("CSS", "JS", false);
        System.out.println("Topological Sort");
        g.bfsTopologicalSort();
    }
}
