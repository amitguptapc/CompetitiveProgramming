package Graphs.StronglyConnectedComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

// Find all components in a directed Graph
// Complexity O(V+E)
public class Kosaraju {
    public LinkedList<Integer>[] adjList, revList;
    public boolean[] visited;
    public Stack<Integer> stk;
    public int v;

    Kosaraju(int n) {
        this.v = n;
        adjList = new LinkedList[v];
        revList = new LinkedList[v];
        visited = new boolean[v];
        stk = new Stack<>();
        for (int i = 0; i < v; i++) {
            this.adjList[i] = new LinkedList<>();
            this.revList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        revList[v].add(u);
    }

    void dfsF(int node) {
        visited[node] = true;
        for (int neighbour : adjList[node]) {
            if (!visited[neighbour])
                dfsF(neighbour);
        }
        stk.push(node);
    }

    void dfsR(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int neighbour : revList[node]) {
            if (!visited[neighbour])
                dfsR(neighbour);
        }
    }

    void getSCC() {
        for (int i = 0; i < v; i++)
            if (!visited[i])
                dfsF(i);

        Arrays.fill(visited, false);
        System.out.println("Strongly connected components are :");
        while (!stk.isEmpty()) {
            int top = stk.pop();
            if (!visited[top]) {
                dfsR(top);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Kosaraju g = new Kosaraju(8);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 0);
        g.addEdge(4, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 7);
        g.getSCC();
    }
}
