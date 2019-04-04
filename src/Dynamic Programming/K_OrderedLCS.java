import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/mancunian-and-k-ordered-lcs-e6a4b8c6/

public class K_OrderedLCS {
    private static int[][][] dp;
    private static int[] a;
    private static int[] b;
    private static int n, m;

    private static int findKlcs(int i, int j, int k) {
        if (i == n || j == m) // any array is completed
            return 0;
        if (dp[i][j][k] != -1)
            return dp[i][j][k];
        int ans = 0;
        if (a[i] == b[j])
            ans = 1 + findKlcs(i + 1, j + 1, k);
        else {
            if (k > 0)
                ans = 1 + findKlcs(i + 1, j + 1, k - 1); // convert one element of array to match
            ans = Math.max(ans, findKlcs(i + 1, j, k));
            ans = Math.max(ans, findKlcs(i, j + 1, k));
        }
        dp[i][j][k] = ans;
        return dp[i][j][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int l = 0; l <= k; l++)
                    dp[i][j][l] = -1;
        System.out.println(findKlcs(0, 0, k));
    }
}