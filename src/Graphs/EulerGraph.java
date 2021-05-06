import java.util.LinkedList;

// Check if a given graph is Eulerian, Semi-Eulerian or Non-Eulerian
public class EulerGraph {
    LinkedList<Integer>[] adjList;
    boolean[] visited;
    int v;

    EulerGraph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    void dfs(int node) {
        visited[node] = true;
        for (int nbr : adjList[node])
            if (!visited[nbr])
                dfs(nbr);
    }

    boolean isConnected() {
        dfs(0);
        for (int i = 0; i < v; i++)
            if (!visited[i] && adjList[i].size() > 0)
                return false;
        return true;
    }

    void checkGraph() {
        if (!isConnected()) {
            System.out.println("Non-Eulerian Graph");
            return;
        }

        int odd = 0;
        for (int i = 0; i < v; i++)
            if ((adjList[i].size() & 1) == 1)
                odd++;

        if (odd > 2)
            System.out.println("Non-Eulerian Graph");
        else if (odd == 0)
            System.out.println("Eulerian Graph");
        else
            System.out.println("Semi-Eulerian Graph");
    }

    public static void main(String[] args) {
        EulerGraph g = new EulerGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.checkGraph();
    }
}