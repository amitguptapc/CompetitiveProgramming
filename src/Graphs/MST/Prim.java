import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// Greedy algorithm
// works for undirected, weighted and connected graph
public class Prim {
    static class Pair<T> {
        T dest;
        int distance;

        Pair(T a, int b) {
            dest = a;
            distance = b;
        }
    }

    static class Graph<T> {
        private HashMap<T, LinkedList<Pair<T>>> adjList = new HashMap<>();

        public void addEdge(T u, T v, int distance) {
            LinkedList<Pair<T>> ll;
            if (!adjList.containsKey(u)) {
                ll = new LinkedList<>();
                adjList.put(u, ll);
            } else
                ll = adjList.get(u);
            ll.add(new Pair<>(v, distance));
            if (!adjList.containsKey(v)) {
                ll = new LinkedList<>();
                adjList.put(v, ll);
            } else
                ll = adjList.get(v);
            ll.add(new Pair<>(u, distance));
        }

        T findMinVert(HashMap<T, Integer> weight, HashMap<T, Boolean> visited, T invalid) {
            T minVertex = invalid;
            for (T node : adjList.keySet()) {
                if (!visited.get(node) && (minVertex == invalid || weight.get(node) < weight.get(minVertex))) {
                    minVertex = node;
                }
            }
            return minVertex;
        }

        void prim(T src, T invalid) {
            HashMap<T, Boolean> visited = new HashMap<>();
            HashMap<T, T> parent = new HashMap<>();
            HashMap<T, Integer> weight = new HashMap<>();
            for (T node : adjList.keySet()) {
                visited.put(node, false);
                weight.put(node, Integer.MAX_VALUE);
            }
            parent.put(src, src);
            weight.put(src, 0);
            for (T node : adjList.keySet()) {
                T minVertex = findMinVert(weight, visited, invalid);
                visited.put(minVertex, true);
                for (Pair<T> neighbour : adjList.get(minVertex)) {
                    if (!visited.get(neighbour.dest) && weight.get(neighbour.dest) > neighbour.distance) {
                        parent.put(neighbour.dest, minVertex);
                        weight.put(neighbour.dest, neighbour.distance);
                    }
                }
            }
            for (T node : adjList.keySet()) {
                System.out.println(node + " - " + parent.get(node) + " weight " + weight.get(node));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph<Integer> g = new Graph<>();
        while (e-- > 0) {
            g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        g.prim(0, -1);
    }
}
/*
Sample Test Case
7 8
0 3 4
0 1 6
1 2 5
3 2 7
3 4 2
4 5 4
5 6 1
4 6 3
 */