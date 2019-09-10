package Graphs.ShortestPath;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

// Greedy Algorithm
// Doesn't work for negative weight edges
// Complexity O(ElogV)
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
        g.printAdjList();

        g.dijkstraSSSP("Amritsar");
    }

    static class Pair<T> implements Comparator<Pair> {
        T dest;
        Integer distance;

        Pair() {
        }

        Pair(T a, int b) {
            dest = a;
            distance = b;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.distance - o2.distance;
        }
    }

    static class Graph<T> {
        private HashMap<T, LinkedList<Pair<T>>> adjList = new HashMap<>();

        public void addEdge(T u, T v, int distance, boolean isBidir) {
            LinkedList<Pair<T>> ll;
            if (!adjList.containsKey(u)) {
                ll = new LinkedList<>();
                adjList.put(u, ll);
            } else
                ll = adjList.get(u);
            ll.add(new Pair<>(v, distance));
            if (isBidir) {
                if (!adjList.containsKey(v)) {
                    ll = new LinkedList<>();
                    adjList.put(v, ll);
                } else
                    ll = adjList.get(v);
                ll.add(new Pair<>(u, distance));
            } else if (!adjList.containsKey(v)) {
                adjList.put(v, new LinkedList<>());
            }
        }

        void printAdjList() {
            for (T val : adjList.keySet()) {
                System.out.print(val + " -> ");
                for (Pair val1 : adjList.get(val))
                    System.out.print("(" + val1.dest + "," + val1.distance + ") ");
                System.out.println();
            }
        }

        void dijkstraSSSP(T src) {
            HashMap<T, Integer> distances = new HashMap<>();
            for (T val : adjList.keySet())
                distances.put(val, Integer.MAX_VALUE);
            TreeSet<Pair<T>> set = new TreeSet<>(new Pair<>());
            distances.put(src, 0);
            set.add(new Pair<>(src, 0));
            while (!set.isEmpty()) {
                Pair<T> p = set.first();
                T node = p.dest;
                int dist = p.distance;
                set.pollFirst();
                for (Pair<T> neighbour : adjList.get(node)) {
                    if (dist + neighbour.distance < distances.get(neighbour.dest)) {
                        T dest = neighbour.dest;
                        set.remove(new Pair<>(dest, distances.get(dest)));
                        distances.put(dest, dist + neighbour.distance);
                        set.add(new Pair<>(dest, distances.get(dest)));
                    }
                }
            }
            for (T d : distances.keySet())
                System.out.println(d + " " + distances.get(d));
        }
    }
}