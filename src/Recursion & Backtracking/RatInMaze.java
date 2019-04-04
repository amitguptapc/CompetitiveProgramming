package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RatInMaze {
    private static boolean solveMaze(char[][] maze, int i, int j, int m, int n) {
        // base case : if destination cell is reached
        if (i == m && j == n) {
            maze[i][j] = '1';
            for (int r = 0; r <= m; r++) {
                for (int c = 0; c <= n; c++)
                    System.out.print(maze[r][c]+" ");
                System.out.println();
            }
            System.out.println();
            return true;
        }

        // if rat moves outside the maze
        if (i > m || j > n)
            return false;

        // if the rat encounters a hurdle
        if (maze[i][j] == 'X')
            return false;

        // mark a cell as path
        maze[i][j] = '1';

        boolean rightSolution = solveMaze(maze, i + 1, j, m, n);
        boolean downSolution = solveMaze(maze, i, j + 1, m, n);

        // removing the marked cell for other paths (BACKTRACKING)
        maze[i][j] = '0';

        return rightSolution || downSolution;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        char[][] maze = new char[m][n];
        for (int i = 0; i < m * n; i++)
            maze[i / n][i % n] = br.readLine().charAt(0);
        if (!solveMaze(maze, 0, 0, m - 1, n - 1))
            System.out.println("No possible path");
    }
}
