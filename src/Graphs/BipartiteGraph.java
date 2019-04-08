package src.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// Bipartite graph is also called 2-coloring graph
// bipartite graph can be colored with 2 colors only
// all the vertices can be divided into 2 sets
// edge exists between vertices of different sets
// no edge occurs between edges of the same set.

public class BipartiteGraph<T> extends Graph<T> {
    private boolean isBipartite(T src) {
        Queue<T> q = new LinkedList<>();
        HashMap<T, Integer> colors = new HashMap<>();
        for (T node : adjList.keySet()) {
            colors.put(node, -1);
        }
        colors.put(src, 0);
        q.add(src);
        while (!q.isEmpty()) {
            T node = q.poll();
            for (T neighbour : adjList.get(node)) {
                if (colors.get(neighbour) == -1) {
                    colors.put(neighbour, 1 - colors.get(node));
                    q.add(neighbour);
                } else if (colors.get(node).equals(colors.get(neighbour)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph<Integer> g = new BipartiteGraph<>();
        g.addEdge(0, 1, true);
        g.addEdge(2, 0, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        g.addEdge(2, 5, true);
        g.addEdge(0, 5, true);
        System.out.println(g.isBipartite(0));
    }
}
