package Backtracking;

// https://www.hackerrank.com/challenges/crossword-puzzle/problem

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Crossword {
    // get next empty cell after the given cell
    private static Point getNextEmptyCell(char[][] grid, int r, int c) {
        for (int i = r; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (i == r && j >= c && grid[i][j] == '-')
                    return new Point(i, j);
                else if (i < r && grid[i][j] == '-')
                    return new Point(i, j);
            }
        }
        return null;
    }

    // to fill the word s in vertical blank space
    private static void fitDown(char[][] grid, int row, int col, String s) {
        for (int i = row; i < 10 && i - row < s.length(); i++)
            grid[i][col] = s.charAt(i - row);
    }

    // to check if the vertical blank can be filled with given word or not
    private static boolean canFitDown(char[][] grid, int r, int c, String s) {
        for (int j = r; j < 10 && j - r < s.length(); j++)
            if (grid[j][c] != '-' && grid[j][c] != s.charAt(j - r))
                return false;
        return true;
    }

    // to starting row no of the blank space having the current cell
    private static int getUpStartRow(char[][] grid, int i, int j) {
        while (i >= 0 && grid[i][j] != '+')
            i--;
        return i + 1;
    }

    // to count the no of empty cells down of the current cell
    private static int getEmptyCellsDown(char[][] grid, int r, int c) {
        int count = 0;
        for (int i = r; i < 10 && grid[i][c] != '+'; i++)
            count++;
        return count;
    }

    // to fill the word s in horizontal blank space
    private static void fitInRight(char[][] grid, int row, int col, String s) {
        for (int j = col; j < 10 && j - col < s.length(); j++)
            grid[row][j] = s.charAt(j - col);
    }

    // to check if the horizontal blank can be filled with given word or not
    private static boolean canFitInRight(char[][] grid, int r, int c, String s) {
        for (int i = c; i < 10 && i - c < s.length(); i++)
            if (grid[r][i] != '-' && grid[r][i] != s.charAt(i - c))
                return false;
        return true;
    }

    // get starting col no of the  blank space having the current non plus cell
    private static int getLHSstartCol(char[][] grid, int i, int j) {
        while (j >= 0 && grid[i][j] != '+')
            j--;
        return j + 1;
    }

    // function to get the count of empty cells in RHS of a given cell
    private static int getEmptyCellsOnRHS(char[][] grid, int rNo, int cNo) {
        int c = 0;
        for (int i = cNo; i < 10 && grid[rNo][i] != '+'; i++)
            c++;
        return c;
    }

    private static void solveCrossword(char[][] grid, HashSet<String> set, int row, int col) {
        if (grid[row][col] == '-') {
            // to store the count of empty cells to the right of row,col(th) cell
            int rNo = getEmptyCellsOnRHS(grid, row, col);

            // to store the starting address of the horizontal blank space
            int lStart = getLHSstartCol(grid, row, col);

            // count the no of cells to fill horizontally
            int cellsToFillHorizontally = (lStart == col) ? rNo : rNo + (col - lStart);
            if (cellsToFillHorizontally > 1) {
                for (String s : set) {
                    if (s.length() == cellsToFillHorizontally && canFitInRight(grid, row, lStart, s)) {

                        // copying grid in case of backtracking in future
                        char[][] gridCopy = new char[10][10];
                        for (int i = 0; i < 10; i++)
                            System.arraycopy(grid[i], 0, gridCopy[i], 0, 10);

                        // copying the set in case of backtracking
                        HashSet<String> setCopy = new HashSet<>(set);
                        setCopy.remove(s);

                        // fill the word in copied puzzle
                        fitInRight(gridCopy, row, lStart, s);
                        Point nextEmptyCell = getNextEmptyCell(gridCopy, row, col);
                        if (nextEmptyCell == null) {
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++)
                                    System.out.print(gridCopy[i][j]);
                                System.out.println();
                            }
                            return;
                        } else
                            solveCrossword(gridCopy, setCopy, nextEmptyCell.x, nextEmptyCell.y);
                    }
                }
            } else {
                // to store no of empty cells down of the current cell
                int dNo = getEmptyCellsDown(grid, row, col);

                // to store the starting address of the vertical blank space
                int uStart = getUpStartRow(grid, row, col);

                // count the no of cells to fill vertically
                int cellsToFillVertically = (uStart == row) ? dNo : dNo + (row - uStart);
                for (String s : set) {
                    if (s.length() == cellsToFillVertically && canFitDown(grid, uStart, col, s)) {
                        // copying grid in case of backtracking in future
                        char[][] gridCopy = new char[10][10];
                        for (int i = 0; i < 10; i++)
                            System.arraycopy(grid[i], 0, gridCopy[i], 0, 10);

                        // copying the set in case of backtracking
                        HashSet<String> setCopy = new HashSet<>(set);
                        setCopy.remove(s);

                        // fill the word in copied puzzle
                        fitDown(gridCopy, uStart, col, s);

                        Point nextEmptyCell = getNextEmptyCell(gridCopy, row, col);
                        if (nextEmptyCell == null) {
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++)
                                    System.out.print(gridCopy[i][j]);
                                System.out.println();
                            }
                            return;
                        } else
                            solveCrossword(gridCopy, setCopy, nextEmptyCell.x, nextEmptyCell.y);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[10][10];
        String s;
        for (int i = 0; i < 10; i++) {
            s = sc.nextLine();
            for (int j = 0; j < 10; j++)
                grid[i][j] = s.charAt(j);
        }
        s = sc.nextLine();
        String[] words = s.split(";");
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        // find the first empty cell from down side of crossword
        outer:
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j <= 9; j++) {
                if (grid[i][j] != '+') {
                    solveCrossword(grid, set, i, j);
                    break outer;
                }
            }
        }
    }
}