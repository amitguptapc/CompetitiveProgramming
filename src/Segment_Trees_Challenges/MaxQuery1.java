import java.util.Scanner;

public class MaxQuery1 {
    private static int[][] tree;
    private static int[] a;

    private static int[] merge(int[] l, int[] r) {
        int n1 = l.length, n2 = r.length, i = 0, j = 0, k = 0;
        int[] merged = new int[n1 + n2];
        while (i < n1 && j < n2)
            if (l[i] <= r[j])
                merged[k++] = l[i++];
            else
                merged[k++] = r[j++];
        while (i < n1)
            merged[k++] = l[i++];
        while (j < n2)
            merged[k++] = r[j++];
        return merged;
    }

    private static int lowerBound(int[] a, int e, int k) {
        int s = 0, m, idx = e + 1;
        while (s <= e) {
            m = (s + e) / 2;
            if (a[m] >= k) {
                idx = m;
                e = m - 1;
            } else
                s = m + 1;
        }
        return idx;
    }

    private static int query(int qs, int qe, int s, int e, int k, int idx) {
        if (qs > e || qe < s)
            return 0;
        if (qs <= s && qe >= e) {
            int nn = tree[idx].length;
            return nn - lowerBound(tree[idx], nn - 1, k);
        }
        int m = (s + e) / 2;
        int l = query(qs, qe, s, m, k, 2 * idx);
        int r = query(qs, qe, m + 1, e, k, 2 * idx + 1);
        return l + r;
    }

    private static void build(int s, int e, int idx) {
        if (s == e) {
            tree[idx] = new int[]{a[s]};
            return;
        }
        int m = (s + e) / 2;
        build(s, m, 2 * idx);
        build(m + 1, e, 2 * idx + 1);
        tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        tree = new int[4 * n + 1][];
        build(0, n - 1, 1);
        int q = sc.nextInt();
        int l, r, k;
        while (q-- > 0) {
            l = sc.nextInt();
            r = sc.nextInt();
            k = sc.nextInt();
            System.out.println(query(l - 1, r - 1, 0, n - 1, k, 1));
        }
    }
}