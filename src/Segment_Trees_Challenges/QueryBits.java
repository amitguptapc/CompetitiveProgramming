import java.util.Arrays;
import java.util.Scanner;

public class QueryBits {
    private static long[] tree, lazy;

    // begin of solution
    private static long mod = 1000000007;

    private static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b = b >> 1;
        }
        return res;
    }

    private static long queryLazy(int ns, int ne, int qs, int qe, int index) {
        // if lazy value present resolve it
        if (lazy[index] != -1) {
            tree[index] = (lazy[index] * (power(2, ne - ns + 1) - 1) % mod) % mod;
            // if it is not a leaf node
            if (ns != ne) {
                lazy[2 * index] = lazy[index];
                lazy[2 * index + 1] = lazy[index];
            }
            lazy[index] = -1;
        }
        // no overlap
        if (qs > ne || qe < ns)
            return 0;
        // complete overlap
        if (qs <= ns && qe >= ne) {
            return tree[index];
        }
        // partial overlap
        int mid = (ns + ne) / 2;
        long left = queryLazy(ns, mid, qs, qe, 2 * index);
        long right = queryLazy(mid + 1, ne, qs, qe, 2 * index + 1);
        if (qe <= mid)
            return left;
        return ((power(2, Math.min(ne, qe) - mid) * left) % mod + right) % mod;
    }

    private static void updateRangeLazy(int s, int e, int l, int r, int inc, int index) {
        // when current node already has some lazy value
        // resolve it and pass lazy value to children
        if (lazy[index] != -1) {
            tree[index] = (lazy[index] * (power(2, e - s + 1) - 1) % mod) % mod;
            ;
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] = lazy[index];
                lazy[2 * index + 1] = lazy[index];
            }
            lazy[index] = -1;
        }
        // no overlap case (out of bounds)
        if (s > r || l > e)
            return;
        // complete overlap
        if (l <= s && r >= e) {
            tree[index] = (inc * (power(2, e - s + 1) - 1) % mod) % mod;
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] = inc;
                lazy[2 * index + 1] = inc;
            }
            return;
        }
        // partial overlap
        int mid = (s + e) / 2;
        updateRangeLazy(s, mid, l, r, inc, 2 * index);
        updateRangeLazy(mid + 1, e, l, r, inc, 2 * index + 1);
        tree[index] = ((power(2, e - mid) * tree[2 * index]) % mod + tree[2 * index + 1]) % mod;
    }


    private static void build(int[] a, int s, int e, long[] tree, int index) {
        // base case
        if (s == e) {
            tree[index] = a[s];
            return;
        }
        int mid = (s + e) / 2;
        build(a, s, mid, tree, 2 * index);
        build(a, mid + 1, e, tree, 2 * index + 1);
        tree[index] = 2 * tree[2 * index] + tree[2 * index + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        tree = new long[4 * n + 1];
        lazy = new long[4 * n + 1];
        Arrays.fill(lazy, -1);
        build(a, 0, n - 1, tree, 1);
        int x, y, z;
        while (q-- > 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            if (x == 1 || x == 0)
                updateRangeLazy(0, n - 1, y, z, x, 1);
            else System.out.println(queryLazy(0, n - 1, y, z, 1));
        }
    }
}