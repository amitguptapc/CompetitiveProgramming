import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// application of connected component
public class Pairing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Cities c = new Cities(n);
        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            c.addEdge(u, v);
        }
        System.out.println(c.findPairs());
    }

    static class Cities {
        int n;
        HashMap<Integer, LinkedList<Integer>> adjList;
        private HashMap<Integer, Boolean> visited = new HashMap<>();

        public Cities(int n) {
            this.n = n;
            adjList = new HashMap<>();
            for (int i = 0; i < n; i++)
                this.adjList.put(i, new LinkedList<>());
        }

        private void addEdge(int u, int v) {
            LinkedList<Integer> l = adjList.get(u);
            l.add(v);
            l = adjList.get(v);
            l.add(u);
        }

        private long dfs(int src) {
            visited.put(src, true);
            long m = 1;
            for (int neighbour : adjList.get(src)) {
                if (!visited.get(neighbour))
                    m += dfs(neighbour);
            }
            return m;
        }

        private long findPairs() {
            for (int i = 0; i < n; i++)
                visited.put(i, false);
            long ans = n * (n - 1) / 2;
            long a = dfs(0);
            ans -= a * (a - 1) / 2;
            for (int node : adjList.keySet()) {
                if (!visited.get(node)) {
                    a = dfs(node);
                    ans -= a * (a - 1) / 2;
                }
            }
            return ans;
        }
    }
}