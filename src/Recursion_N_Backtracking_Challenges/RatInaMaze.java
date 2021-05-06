import java.util.Scanner;

public class RatInaMaze {
    private static boolean findWay(char[][] maze, int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            maze[i][j] = '1';
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (maze[r][c] == 'X' || maze[r][c] == 'O')
                        System.out.print(0 + " ");
                    else System.out.print(maze[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }
        if (i >= n || j >= m)
            return false;
        if (maze[i][j] == 'X')
            return false;
        maze[i][j] = '1';
        if (findWay(maze, i, j + 1, n, m) || findWay(maze, i + 1, j, n, m))
            return true;
        maze[i][j] = 'O';
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++)
            maze[i] = sc.next().toCharArray();
        if (!findWay(maze, 0, 0, n, m))
            System.out.println(-1);
    }
}