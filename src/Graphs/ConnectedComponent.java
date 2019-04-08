package src.Graphs;

public class ConnectedComponent<T> extends DFS<T> {
    public void connectedComponent(T src) {
        int component = 1;
        dfs(src);
        System.out.println();
        for (T node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node);
                System.out.println();
                component++;
            }
        }
        System.out.println("No of components are : " + component);
    }

    public static void main(String[] args) {
        ConnectedComponent<Integer> g = new ConnectedComponent<>();
        g.addEdge(0, 1, true);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        g.connectedComponent(0);
    }
}