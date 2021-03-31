import java.util.Scanner;
import java.util.TreeSet;

// Given a n*n board, with m number of horses
// each horse can move in the top & left directions
// i.e. their down 4 moves are truncated
// two players play the game, find the winner.
public class KnightGame {
    private static final int[] xInc = {-1, 1, -2, -2};
    private static final int[] yInc = {-2, -2, -1, 1};

    private static int findMex(TreeSet<Integer> set) {
        int mex = 0;
        while (set.size() != 0 && set.first() == mex) {
            set.pollFirst();
            mex++;
        }
        return mex;
    }

    private static void findGrundy(int[][] board, int n) {
        int x, y, nx, ny;
        // filling in left diagonal manner /
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i < n) {
                x = i;
                y = 0;
            } else {
                x = n - 1;
                y = i - n;
            }
            while (x >= 0 && y < n) {
                TreeSet<Integer> set = new TreeSet<>();
                for (int k = 0; k < 4; k++) {
                    nx = x + xInc[k];
                    ny = y + yInc[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n)
                        set.add(board[nx][ny]);
                }
                board[x][y] = findMex(set);
                x--;
                y++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // size of board
        int[][] board = new int[n][n];
        int m = sc.nextInt(); // no of horses
        int[][] pos = new int[m][2]; // position of horses
        for (int i = 0; i < m; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }
        findGrundy(board, n);
        int ans = 0;
        for (int i = 0; i < m; i++)
            ans ^= board[pos[i][0]][pos[i][1]];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(ans == 0 ? "B wins" : "A wins");
    }
}