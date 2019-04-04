import java.util.Arrays;
import java.util.Scanner;

// Range Minimum Query using Segment Trees
public class RMQ {
    private static void updateRange(int[] tree, int s, int e, int l, int r, int inc, int index) {
        // out of range
        if (s > r || e < l)
            return;
        // leaf node
        if (s == e) {
            tree[index] += inc;
            return;
        }
        // recursively compute the new minimum
        int mid = (s + e) / 2;
        updateRange(tree, s, mid, l, r, inc, 2 * index);
        updateRange(tree, mid + 1, e, l, r, inc, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

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
        // base case
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
        int[] a = {1, 3, 2, -5, 6, 4};
        int n = 6;

        // calculating size of segment tree
        int m = (int) Math.ceil(Math.log(n) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, m + 1)];

        build(a, 0, n - 1, tree, 1);
        System.out.println(query(tree, 0, 2, 0, n - 1, 1));
        int x = sc.nextInt();
        int inc = sc.nextInt();
        updateNode(tree, 0, n - 1, x, inc, 1);
        System.out.println(Arrays.toString(tree));
        System.out.println(query(tree, 0, 5, 0, n - 1, 1));
        updateRange(tree, 0, 5, 2, 4, -10, 1);
        System.out.println(Arrays.toString(tree));
        System.out.println(query(tree, 0, 5, 0, 5, 1));
    }
}