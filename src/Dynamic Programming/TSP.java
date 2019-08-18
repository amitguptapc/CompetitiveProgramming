// TSP finds the minimum weight hamiltonian cycle
// every node is visited only once and return back to the starting node.

// Complexity of Memoized solution is (2^n)*n
public class TSP {
    private static int n = 4;
    private static int[][] dist = {
            {0, 20, 42, 25},
            {20, 0, 30, 34},
            {42, 30, 0, 10},
            {25, 34, 10, 0}
    };
    private static int[][] dp;
    private static int visitedAll = (1 << n) - 1;

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
        dp = new int[(int) Math.pow(2, n)][n];
        for (int i = 0; i < Math.pow(2, n); i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        System.out.println(tsp(1, 0));
    }
}