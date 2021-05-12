package BitmaskDP;

import java.util.Scanner;

public class TSP {

    private static int[][] adj, dp;
    private static int n, visited;

    /*
    Complexity : O ( N * 2^N )
    TSP is a minimum weight hamiltonian cycle
    */
    private static int solve(int mask, int pos) {
        if (mask == visited)
            return adj[pos][0];

        if (dp[mask][pos] != -1)
            return dp[mask][pos];

        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int temp = adj[pos][city] + solve(mask | (1 << city), city);
                ans = Math.min(ans, temp);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // no of vertices
        adj = new int[n][n];

        for (int i = 0; i < n; i++) // input of adjacency matrix
            for (int j = 0; j < n; j++)
                adj[i][j] = sc.nextInt();

        int m = 1 << n;
        visited = (1 << n) - 1;

        dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        System.out.println(solve(1, 0));
    }
}
