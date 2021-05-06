package Dynamic_Programming.GridBasedDP;

import java.util.Scanner;

// https://codeforces.com/problemset/problem/429/B
public class WorkingOut {
    public static int getMaxCalories(int[][] calorie, int n, int m) {
        int[][] boyEnter = new int[n + 2][m + 2];
        int[][] boyExit = new int[n + 2][m + 2];
        int[][] girlEnter = new int[n + 2][m + 2];
        int[][] girlExit = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                boyEnter[i][j] = calorie[i][j] + Math.max(boyEnter[i - 1][j], boyEnter[i][j - 1]);

        for (int i = n; i >= 1; i--)
            for (int j = m; j >= 1; j--)
                boyExit[i][j] = calorie[i][j] + Math.max(boyExit[i + 1][j], boyExit[i][j + 1]);

        for (int i = n; i >= 1; i--)
            for (int j = 1; j <= m; j++)
                girlEnter[i][j] = calorie[i][j] + Math.max(girlEnter[i + 1][j], girlEnter[i][j - 1]);

        for (int i = 1; i <= n; i++)
            for (int j = m; j >= 1; j--)
                girlExit[i][j] = calorie[i][j] + Math.max(girlExit[i - 1][j], girlExit[i][j + 1]);

        int ans = 0, op1, op2;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                op1 = boyEnter[i][j - 1] + boyExit[i][j + 1] + girlEnter[i + 1][j] + girlExit[i - 1][j]; // boy enters from left and girl enters from down
                op2 = boyEnter[i - 1][j] + boyExit[i + 1][j] + girlEnter[i][j - 1] + girlExit[i][j + 1]; // boy enter from top and girl enters from left
                ans = Math.max(ans, Math.max(op1, op2));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] calorie = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                calorie[i][j] = sc.nextInt();
        System.out.println(getMaxCalories(calorie, n, m));
    }
}
