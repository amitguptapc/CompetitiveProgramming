package Dynamic_Programming.TwoDimensionalDP;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/1200/D
public class SquarePainting {
    public static int solve(int[][] a, int n, int k) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] prefixT = new int[n][n];
        int[][] prefixL = new int[n][n];
        int[][] suffixD = new int[n][n];
        int[][] suffixR = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = prefixL[i][j] = prefixT[i][j] = suffixR[i][j] = suffixD[i][j] = sc.nextInt() == 'B' ? 0 : 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < n; j++)
                prefixT[i][j] += prefixT[i - 1][j];
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j++)
                prefixL[i][j] += prefixL[i][j - 1];
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j < n; j++)
                suffixD[i][j] += suffixD[i + 1][j];
        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                suffixR[i][j] += suffixR[i][j + 1];

        System.out.println(solve(a, n, k));
    }
}
