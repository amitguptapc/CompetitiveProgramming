import java.util.*;

public class SnakeNLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] board = new int[101];
            // for ladders
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                board[u] = v - u;
            }
            // for snakes
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                board[u] = v - u;
            }
            // building the board
            Board b = new Board(100);
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 6; j++) {
                    if (i + j <= 100)
                        b.addEdge(i, i + j + board[i + j]);
                }
            }
            System.out.println(b.minMoves());
        }
    }

    static class Board {
        public Map<Integer, LinkedList<Integer>> adjList;
        private int n;

        public Board(int n) {
            this.n = n;
            adjList = new HashMap<>();
            for (int i = 1; i <= n; i++)
                this.adjList.put(i, new LinkedList<>());
        }

        public void addEdge(int u, int v) {
            LinkedList<Integer> l1;
            if (!adjList.containsKey(u)) {
                l1 = new LinkedList<>();
                adjList.put(u, l1);
            } else
                l1 = adjList.get(u);
            l1.add(v);
            if (!adjList.containsKey(v)) {
                adjList.put(v, new LinkedList<>());
            }
        }

        private int minMoves() {
            Queue<Integer> q = new LinkedList<>();
            Map<Integer, Integer> distance = new HashMap<>();
            for (int i = 1; i <= n; i++)
                distance.put(i, -1);
            q.add(1);
            distance.put(1, 0);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbour : adjList.get(node)) {
                    if (distance.get(neighbour) == -1) {
                        q.add(neighbour);
                        distance.put(neighbour, distance.get(node) + 1);
                    }
                }
            }
            return distance.get(100);
        }
    }
}