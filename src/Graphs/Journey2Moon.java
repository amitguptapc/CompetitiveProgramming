package src.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem
public class Journey2Moon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        Citizen g = new Citizen(n);
        for (int i = 0; i < p; i++) {
            g.addEdge(sc.nextInt(), sc.nextInt());
        }
        System.out.println(g.dfsMoon());
    }

    static class Citizen {
        public HashMap<Integer, LinkedList<Integer>> l = new HashMap<>();
        private long N;
        private int size;

        Citizen(int n) {
            N = n;
            for (int i = 0; i < N; i++) {
                l.put(i, new LinkedList<>());
            }
        }

        public void addEdge(int u, int v) {
            LinkedList<Integer> l1 = l.get(u);
            l1.add(v);
            l.put(u, l1);
            LinkedList<Integer> l2 = l.get(v);
            l2.add(u);
            l.put(v, l2);
        }

        private void dfs(Integer node, HashMap<Integer, Boolean> visited) {
            visited.put(node, true);
            size++;
            for (Integer neighbour : l.get(node)) {
                if (!visited.get(neighbour)) {
                    dfs(neighbour, visited);
                }
            }
        }

        long dfsMoon() {
            HashMap<Integer, Boolean> visited = new HashMap<>();
            for (int i = 0; i < N; i++)
                visited.put(i, false);
            long totalWays = N * (N - 1) / 2;
            for (int node = 0; node < N; node++)
                if (!visited.get(node)) {
                    size = 0;
                    dfs(node, visited);
                    totalWays -= size * (size - 1) / 2;
                }
            return totalWays;
        }
    }

}
