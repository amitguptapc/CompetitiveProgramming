package Graphs.StronglyConnectedComponent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

// find all strongly connected components in a directed graph using Tarjan's Algorithm
// Complexity O(V+E)
public class Tarjan {
    int v;
    int time;
    int[] low; // to store the lowest time
    int[] discovery; // to store the time of discovery of each vertex
    boolean[] inStack; // to check whether any element is present in stack or not
    Stack<Integer> stk;
    LinkedList<Integer>[] adjList;

    Tarjan(int v) {
        this.time = 0;
        this.v = v;
        adjList = new LinkedList[v];
        low = new int[v];
        discovery = new int[v];
        inStack = new boolean[v];
        stk = new Stack<>();
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
        Arrays.fill(low, -1);
        Arrays.fill(discovery, -1);
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    void SCC(int u) {
        discovery[u] = time;
        low[u] = time;
        time++;
        stk.push(u);
        inStack[u] = true;
        for (int nbr : adjList[u]) {
            if (discovery[nbr] == -1) {
                SCC(nbr);
                low[u] = Math.min(low[u], low[nbr]);
            } else if (inStack[nbr]) { // check for back edge
                low[u] = Math.min(low[u], discovery[nbr]);
            }
        }
        if (low[u] == discovery[u]) { // to find head of SCC
            int top = -1;
            while (top != u) {
                top = stk.pop();
                System.out.print(top + " ");
                inStack[top] = false;
            }
            System.out.println();
        }
    }

    void findSCC() {
        System.out.println("Strongly Connected Components are :");
        for (int i = 0; i < this.v; i++)
            if (discovery[i] == -1)
                SCC(i);
    }

    public static void main(String[] args) {
        Tarjan g = new Tarjan(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 5);
        g.findSCC();
    }
}
