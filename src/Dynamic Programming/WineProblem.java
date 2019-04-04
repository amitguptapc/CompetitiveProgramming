import java.util.Scanner;

public class WineProblem {
    private static int[][] memo;

    // Pure Dp
    private static int maxProfit3(int[] price, int n) {
        int[][] a = new int[n][n];
        int year = n;
        for (int i = 0; i < n; i++) {
            int j = i, k = 0;
            while (j < n) {
                if (k == j)
                    a[k][j] = price[k] * year;
                else {
                    a[k][j] = Math.max(price[k] * year + a[k + 1][j], price[j] * year + a[k][j - 1]);
                }
                k++;
                j++;
            }
            year--;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + "\t");
            System.out.println();
        }
        return a[0][n - 1];
    }

    // Memoization
    private static int maxProfit2(int[] price, int start, int end, int year) {
        if (start > end)
            return 0;
        if (memo[start][end] != -1)
            return memo[start][end];
        int x = price[start] * year + maxProfit2(price, start + 1, end, year + 1);
        int y = price[end] * year + maxProfit2(price, start, end - 1, year + 1);
        memo[start][end] = Math.max(x, y);
        return memo[start][end];
    }

    // Naive
    private static int maxProfit1(int[] price, int start, int end, int year) {
        if (start > end)
            return 0;
        int x = price[start] * year + maxProfit1(price, start + 1, end, year + 1);
        int y = price[end] * year + maxProfit1(price, start, end - 1, year + 1);
        return Math.max(x, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();
        memo = new int[n][n];
        for (int i = 0; i < n * n; i++)
            memo[i / n][i % n] = -1;
//        System.out.println(maxProfit2(price, 0, n - 1, 1));
        System.out.println(maxProfit3(price, n));
    }
}