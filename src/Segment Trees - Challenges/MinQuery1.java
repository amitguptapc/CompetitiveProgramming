import java.util.Scanner;

public class MinQuery1 {
    private static void updateNode(int[] tree, int s, int e, int i, int inc, int index) {
        // base case ,if out of range
        if (s > i || e < i)
            return;

        // when element to be updated is reached
        if (s == e) {
            tree[index] += inc;
            return;
        }

        // recursively compute the new minimum
        int mid = (s + e) / 2;
        updateNode(tree, s, mid, i, inc, 2 * index);
        updateNode(tree, mid + 1, e, i, inc, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    private static int query(int[] tree, int qs, int qe, int ns, int ne, int index) {
        // complete overlap
        if (qs <= ns && qe >= ne)
            return tree[index];
        // no overlap
        if (ne < qs || qe < ns)
            return Integer.MAX_VALUE;
        // partial overlap
        int mid = (ns + ne) / 2;
        // querying left child
        int left = query(tree, qs, qe, ns, mid, 2 * index);
        // querying right child
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
        int m = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, m + 1)];
        build(a, 0, n - 1, tree, 1);
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            if (l == 1)
                System.out.println(query(tree, r - 1, x - 1, 0, n - 1, 1));
            else
                updateNode(tree, 0, n - 1, r - 1, x - a[r - 1], 1);
        }
    }
}