import java.util.Scanner;

public class RobotPoints {
    private static int maxScore(int[][] grid, int i, int j) {
        if (i <= 0)
            return 0;
        int a1, a2, a3;
        a1 = a2 = a3 = Integer.MIN_VALUE;
        if (j - 1 >= 0)
            a1 = grid[i - 1][j - 1] + maxScore(grid, i - 1, j - 1);
        a2 = grid[i - 1][j] + maxScore(grid, i - 1, j);
        if (j + 1 < 5)
            a3 = grid[i - 1][j + 1] + maxScore(grid, i - 1, j + 1);
        return Math.max(a1, Math.max(a2, a3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int[][] grid = new int[h][5];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < 5; j++) {
                    grid[i][j] = sc.nextInt();
                    if (grid[i][j] == -1 && h - i <= 5)
                        grid[i][j] = 0;
                }
            }
            System.out.println(maxScore(grid, h, 2));
        }
    }
}