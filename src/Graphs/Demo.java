package src.Graphs;

import Graphs.Graph;

public class Demo {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, false);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);
        System.out.println("Adjacency List : ");
        g.printAdjList();
    }
}