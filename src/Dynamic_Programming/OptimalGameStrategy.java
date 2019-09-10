import java.util.Scanner;

public class OptimalGameStrategy {
    private static int winnerScore(int[] a, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int s = 0, e = i;
            while (s < n && e < n) {
                if (s == e)
                    dp[s][e] = a[s];
                else if (s + 1 == e)
                    dp[s][e] = Math.max(a[s], a[e]);
                else {
                    int x = 0, y = 0, z = 0;
                    if (s + 1 <= e - 1)
                        x = dp[s + 1][e - 1];
                    if (s + 2 <= e)
                        y = dp[s + 2][e];
                    if (s <= e - 2)
                        z = dp[s][e - 2];
                    dp[s][e] = Math.max(a[s] + Math.min(x, y), a[e] + Math.min(z, x));
                }
                s++;
                e++;
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++)
//                System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(winnerScore(a, n));
    }
}