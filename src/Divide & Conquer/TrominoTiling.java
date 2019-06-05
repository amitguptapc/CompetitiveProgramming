import java.util.Scanner;

public class TrominoTiling {
    private static int[][] board;
    private static int count = 0;

    private static void fillTile(int x1, int y1, int x2, int y2, int x3, int y3) {
        count++;
        board[x1][y1] = count;
        board[x2][y2] = count;
        board[x3][y3] = count;
    }

    private static void fillTromino(int n, int x, int y) {
        if (n == 2) {
            count++;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (board[x + i][y + j] == 0)
                        board[x + i][y + j] = count;
            return;
        }
        int r = 0, c = 0; // for location of hole
        hole:
        for (int i = x; i < x + n; i++)
            for (int j = y; j < y + n; j++)
                if (board[i][j] != 0) {
                    r = i;
                    c = j;
                    break hole;
                }
        if (r < x + n / 2 && c < y + n / 2) // if hole is in first quadrant
            fillTile(x + n / 2, y + n / 2 - 1, x + n / 2, y + n / 2, x + n / 2 - 1, y + n / 2);
        else if (r < x + n / 2 && c >= y + n / 2) // if hole is in second quadrant
            fillTile(x + n / 2, y + n / 2 - 1, x + n / 2, y + n / 2, x + n / 2 - 1, y + n / 2 - 1);
        else if (r >= x + n / 2 && c < y + n / 2) // if hole is in third quadrant
            fillTile(x + n / 2 - 1, y + n / 2, x + n / 2, y + n / 2, x + n / 2 - 1, y + n / 2 - 1);
        else if (r >= x + n / 2 && c >= y + n / 2) // if hole is in fourth quadrant
            fillTile(x + n / 2 - 1, y + n / 2, x + n / 2, y + n / 2 - 1, x + n / 2 - 1, y + n / 2 - 1);
        // recursive call for all the 4 quadrants
        fillTromino(n / 2, x, y + n / 2);
        fillTromino(n / 2, x, y);
        fillTromino(n / 2, x + n / 2, y);
        fillTromino(n / 2, x + n / 2, y + n / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = (int) Math.pow(2, k);
        board = new int[n][n];
        board[r][c] = -1;
        fillTromino(n, 0, 0);
        board[r][c] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }
}