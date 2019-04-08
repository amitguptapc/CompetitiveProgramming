package src.Graphs;

import java.util.ArrayList;

// cycle is detected in undirected graph using dfs
public class CycleDetectionDFS<T> extends Graph<T> {
    private boolean isCyclicHelper(T node, T parent, ArrayList<T> visited) {
        visited.add(node);
        for (T neighbour : adjList.get(node)) {
            if (!visited.contains(neighbour)) {
                if (isCyclicHelper(neighbour, node, visited))
                    return true;
            } else if (!neighbour.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic() {
        ArrayList<T> visited = new ArrayList<>();
        for (T node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (isCyclicHelper(node, node, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDFS<Integer> g = new CycleDetectionDFS<>();
        g.addEdge(1, 2, true);
        g.addEdge(3, 2, true);
        g.addEdge(3, 4, true);
//        g.addEdge(1, 4, true);
        System.out.println("Cycle is present : " + g.isCyclic());
    }
}
