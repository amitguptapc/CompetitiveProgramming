import java.util.Scanner;

// RSQ (Range Sum Query) using Fenwick Tree
public class RangeSum {
    private static int[] BIT;
    private static int n;

    private static int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & (-i));
        }
        return sum;
    }

    private static void update(int i, int inc) {
        while (i <= n) {
            BIT[i] += inc;
            i += (i & (-i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        BIT = new int[n + 1];
        for (int i = 1; i <= n; i++)
            update(i, sc.nextInt());
        int q = sc.nextInt();
        int l, r;
        while (q > 0) {
            l = sc.nextInt();
            r = sc.nextInt();
            System.out.println(query(r) - query(l - 1));
            q--;
        }
    }
}