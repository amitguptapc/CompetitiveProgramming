import java.util.Scanner;

public class MinQuery1 {
    private static void update(int[] tree, int s, int e, int i, int inc, int index) {
        if (s > i || e < i)
            return;
        if (s == e) {
            tree[index] = inc;
            return;
        }
        int mid = (s + e) / 2;
        update(tree, s, mid, i, inc, 2 * index);
        update(tree, mid + 1, e, i, inc, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    private static int query(int[] tree, int qs, int qe, int ns, int ne, int index) {
        if (qs <= ns && qe >= ne)
            return tree[index];
        if (ne < qs || qe < ns)
            return Integer.MAX_VALUE;
        int mid = (ns + ne) / 2;
        int left = query(tree, qs, qe, ns, mid, 2 * index);
        int right = query(tree, qs, qe, mid + 1, ne, 2 * index + 1);
        return Math.min(left, right);
    }

    private static void build(int[] a, int s, int e, int[] tree, int index) {
        if (s == e) {
            tree[index] = a[s];
            return;
        }
        int mid = (s + e) / 2;
        build(a, s, mid, tree, 2 * index);
        build(a, mid + 1, e, tree, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int[] tree = new int[4 * n + 1];
        build(a, 0, n - 1, tree, 1);
        int x, y, z;
        while (q-- > 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            if (x == 1) {
                System.out.println(query(tree, y - 1, z - 1, 0, n - 1, 1));
            } else {
                update(tree, 0, n - 1, y - 1, z, 1);
            }
        }
    }
}