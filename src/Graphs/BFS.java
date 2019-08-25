package src.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> extends src.Graphs.Graph<T> {
    private void bfs(T start) {
        Queue<T> q = new LinkedList<>();
        // to store the vertices which are visited
        ArrayList<T> visited = new ArrayList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            T node = q.poll();
            System.out.print(node + " ");
            for (T neighbour : adjList.get(node)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS<Integer> g = new BFS<>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        System.out.println("Breadth First Search : ");
        g.bfs(0);
    }
}
