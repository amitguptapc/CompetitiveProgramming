package Graphs.ShortestPath;

import java.util.*;

// Greedy Algorithm
// Doesn't work for negative weight edges
// Works for both directed as well as undirected graph
// Complexity O(E log V) using Adjacency List
// and O(V*V) for Adjacency Matrix

public class Dijkstra {
    public static void main(String[] args) {
        Graph<String> g = new Graph<>();
        g.addEdge("Amritsar", "Delhi", 1, true);
        g.addEdge("Amritsar", "Jaipur", 4, true);
        g.addEdge("Jaipur", "Delhi", 2, true);
        g.addEdge("Jaipur", "Mumbai", 8, true);
        g.addEdge("Bhopal", "Agra", 2, true);
        g.addEdge("Mumbai", "Bhopal", 3, true);
        g.addEdge("Agra", "Delhi", 1, true);
//        g.printAdjList();
        g.dijkstraSSSP("Amritsar");
    }

    static class Edge<T> implements Comparator<Edge<T>> {
        T dest;
        Integer distance;

        Edge() {
            distance = 0;
            dest = null;
        }

        Edge(T a, int b) {
            dest = a;
            distance = b;
        }

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.distance - o2.distance;
        }
    }

    static class Graph<T> {
        private Map<T, LinkedList<Edge<T>>> adjList = new HashMap<>();

        public void addEdge(T u, T v, int distance, boolean isBidir) {
            LinkedList<Edge<T>> ll;
            if (!adjList.containsKey(u)) {
                ll = new LinkedList<>();
                adjList.put(u, ll);
            } else
                ll = adjList.get(u);
            ll.add(new Edge<>(v, distance));
            if (isBidir) {
                if (!adjList.containsKey(v)) {
                    ll = new LinkedList<>();
                    adjList.put(v, ll);
                } else
                    ll = adjList.get(v);
                ll.add(new Edge<>(u, distance));
            } else if (!adjList.containsKey(v)) {
                adjList.put(v, new LinkedList<>());
            }
        }

        void printAdjList() {
            for (T val : adjList.keySet()) {
                System.out.print(val + " -> ");
                for (Edge<T> val1 : adjList.get(val))
                    System.out.print("(" + val1.dest + "," + val1.distance + ") ");
                System.out.println();
            }
        }

        void dijkstraSSSP(T src) {
            Map<T, Integer> distances = new HashMap<>();
            for (T val : adjList.keySet())  // set all distances to max
                distances.put(val, Integer.MAX_VALUE);

            Map<T, T> parent = new HashMap<>();
            parent.put(src, src);

            TreeSet<Edge<T>> set = new TreeSet<>(new Edge<>());
            distances.put(src, 0); // set to find nodes with min distance
            set.add(new Edge<>(src, 0));

            while (!set.isEmpty()) {

                Edge<T> p = set.first();
                T node = p.dest;
                int dist = p.distance;
                set.pollFirst();

                for (Edge<T> neighbour : adjList.get(node)) {
                    if (dist + neighbour.distance < distances.get(neighbour.dest)) {
                        T dest = neighbour.dest;
                        set.remove(new Edge<>(dest, distances.get(dest)));
                        distances.put(dest, dist + neighbour.distance);
                        set.add(new Edge<>(dest, distances.get(dest)));
                        parent.put(neighbour.dest, node);
                    }
                }
            }

            for (T d : distances.keySet()) {
                System.out.println(d + " " + distances.get(d));
                printPath(d, parent);
                System.out.println();
            }
        }

        private void printPath(T d, Map<T, T> parent) {
            if (parent.get(d) != d)
                printPath((parent.get(d)), parent);
            System.out.print(d + " -> ");
        }
    }
}