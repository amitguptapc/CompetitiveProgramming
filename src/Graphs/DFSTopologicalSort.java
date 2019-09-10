package src.Graphs;

import java.util.ArrayList;

// Topological Sort is applicable on DAG (Directed Acyclic Graph)
public class DFSTopologicalSort<T> extends src.Graphs.Graph<T> {
    public static void main(String[] args) {
        DFSTopologicalSort<String> g = new DFSTopologicalSort<>();
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
        g.dfsTopologicalSort();
    }

    private void dfs(T node, ArrayList<T> visited, ArrayList<T> ordering) {
        visited.add(node);
        for (T neighbour : adjList.get(node)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited, ordering);
            }
        }
        ordering.add(0, node);
    }

    private void dfsTopologicalSort() {
        ArrayList<T> visited = new ArrayList<>();
        ArrayList<T> ordering = new ArrayList<>();
        for (T node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, ordering);
            }
        }
        for (T node : ordering) {
            System.out.print(node + " -> ");
        }
    }
}