package src.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

class Citizen {
    public HashMap<Integer, LinkedList<Integer>> l = new HashMap<>();
    private int N;
    private int size;

    public Citizen(int n) {
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

    private void dfs(Integer node, ArrayList<Integer> visited) {
        visited.add(node);
        size++;
        for (Integer neighbour : l.get(node)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited);
            }
        }
    }

    public int dfsMoon() {
        ArrayList<Integer> visited = new ArrayList<>();
        int totalWays = N * (N - 1) / 2;
        for (int node = 0; node < N; node++)
            if (!visited.contains(node)) {
                size = 0;
                dfs(node, visited);
                totalWays -= size * (size - 1) / 2;
            }
        return totalWays;
    }
}

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

}
