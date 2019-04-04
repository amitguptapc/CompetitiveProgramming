// Print all possible solutions of N-Queen Problem using Bit sets.

import java.util.BitSet;
import java.util.Scanner;

// Complexity O(1)

public class NQueenBitsets {
    private static BitSet d1, d2, col;
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d1 = new BitSet(2 * n - 1);
        d2 = new BitSet(2 * n - 1);
        col = new BitSet(n);
        int a[][] = new int[n][n];
        solve(0, n, a);
        System.out.println("No of possible solutions are : " + ans);
    }

    private static void solve(int r, int n, int a[][]) {
        if (r == n) {
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++)
                    if (a[k][l] == 1)
                        System.out.print("Q  ");
                    else
                        System.out.print("-  ");

                System.out.println();
            }
            System.out.println();
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.get(i) && !d1.get(r - i + n - 1) && !d2.get(r + i)) {

                col.set(i);
                d1.set(r - i + n - 1);
                d2.set(r + i);

                a[r][i] = 1;
                solve(r + 1, n, a);

                col.set(i, false);
                d1.set(r - i + n - 1, false);
                d2.set(r + i, false);

                a[r][i] = 0;
            }
        }
    }
}