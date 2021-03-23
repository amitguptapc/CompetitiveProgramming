import java.util.Scanner;

// TSP finds the minimum weight hamiltonian cycle
// every node is visited once and return back to the starting node.
// Complexity of Memoized solution is (2^n)*n
public class TSP {
    private static int n;
    private static int[][] dist;
    private static int[][] dp;
    private static int visitedAll;

    private static int tsp(int mask, int pos) {
        if (mask == visitedAll)
            return dist[pos][0];
        if (dp[mask][pos] != -1)
            return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        // try to go to cities which are not visited
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int temp = dist[pos][city] + tsp(mask | (1 << city), city);
                ans = Math.min(ans, temp);
            }
        }
        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visitedAll = (1 << n) - 1;
        dp = new int[1 << n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) // input of adjacency matrix
            for (int j = 0; j < n; j++)
                dist[i][j] = sc.nextInt();
        for (int i = 0; i < 1 << n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        System.out.println(tsp(1, 0));
    }
}