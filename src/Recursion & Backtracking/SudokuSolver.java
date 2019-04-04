package Backtracking;

public class SudokuSolver {
    private static boolean canPlace(int[][] grid, int x, int y, int num) {
        // check for number in row and column
        for (int i = 0; i < 9; i++)
            if (grid[x][i] == num || grid[i][y] == num)
                return false;

        // sx and sy store the starting index of the grid to which the given element belongs
        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;

        // check for the presence of num in the grid
        for (int i = sx; i < sx + 3; i++)
            for (int j = sy; j < sy + 3; j++)
                if (grid[i][j] == num)
                    return false;

        return true;
    }

    private static boolean solve(int[][] grid, int i, int j) {
        // base case : when all cells are filled
        if (i == 9) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++)
                    System.out.print(grid[r][c] + " ");
                System.out.println();
            }
            return true;
        }

        // if column length exceeds 9
        if (j == 9)
            return solve(grid, i + 1, 0);

        // if it is pre-filled
        if (grid[i][j] != 0)
            return solve(grid, i, j + 1);

        // for unfilled values
        for (int num = 1; num <= 9; num++) {
            if (canPlace(grid, i, j, num)) {
                grid[i][j] = num;
                if (solve(grid, i, j + 1))
                    return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        solve(grid, 0, 0);
    }
}
