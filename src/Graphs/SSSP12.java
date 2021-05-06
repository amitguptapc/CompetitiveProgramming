package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Find single source shortest path in a graph having edges of weight 1 or 2 using BFS
public class SSSP12 {
    int v;
    LinkedList<Integer>[] adjList;

    SSSP12(int v) {
        this.v = v;
        adjList = new LinkedList[2 * this.v];
        for (int i = 0; i < 2 * v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int x, int y, int w) {
        if (w == 1)
            adjList[x].add(y);
        else { // add two edges of weight 1 each for every edge of weight 2
            adjList[x].add(x + v);
            adjList[x + v].add(y);
        }
    }

    void sssp(int src) {
        int[] distance = new int[2 * v];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        distance[src] = 0;
        while (!q.isEmpty()) {
            int top = q.poll();
            for (int nbr : adjList[top]) {
                if (distance[nbr] == -1) {
                    q.add(nbr);
                    distance[nbr] = distance[top] + 1;
                }
            }
        }
        for (int i = 0; i < v; i++)
            System.out.println("Distance of " + i + " from " + src + " is : " + distance[i]);
    }

    public static void main(String[] args) {
        SSSP12 g = new SSSP12(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 4, 2);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 2);
        g.addEdge(2, 4, 2);
        g.addEdge(3, 4, 1);
        g.sssp(0);
    }
}