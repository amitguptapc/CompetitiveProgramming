import java.util.Arrays;

// Range Minimum Query with LAZY PROPAGATION
public class LazyRMQ {
    private static int[] tree;
    private static int[] lazy;

    private static int queryLazy(int ns, int ne, int qs, int qe, int index) {
        // if lazy value present resolve it
        if (lazy[index] != 0) {
            tree[index] += lazy[index];
            // if it is not a leaf node
            if (ns != ne) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }
        // no overlap
        if (qs > ne || qe < ns)
            return Integer.MAX_VALUE;
        // complete overlap
        if (qs <= ns && qe >= ne) {
            return tree[index];
        }
        // partial overlap
        int mid = (ns + ne) / 2;
        int left = queryLazy(ns, mid, qs, qe, 2 * index);
        int right = queryLazy(mid + 1, ne, qs, qe, 2 * index + 1);
        return Math.min(left, right);
    }

    private static void updateRangeLazy(int s, int e, int l, int r, int inc, int index) {
        // when current node already has some lazy value
        // resolve it and pass lazy value to children
        if (lazy[index] != 0) {
            tree[index] += lazy[index];
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }
        // no overlap case (out of bounds)
        if (s > r || l > e)
            return;
        // complete overlap
        if (l <= s && r >= e) {
            tree[index] += inc;
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] += inc;
                lazy[2 * index + 1] += inc;
            }
            return;
        }
        // partial overlap
        int mid = (s + e) / 2;
        updateRangeLazy(s, mid, l, r, inc, 2 * index);
        updateRangeLazy(mid + 1, e, l, r, inc, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    private static void build(int[] arr, int s, int e, int index) {
        if (s == e) {
            tree[index] = arr[s];
            return;
        }
        int mid = (s + e) / 2;
        build(arr, s, mid, 2 * index);
        build(arr, mid + 1, e, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, -5, 6, 4};
        int n = 6;
        // size of segment tree
        int m = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1);
        tree = new int[m];
        lazy = new int[m];
        build(arr, 0, n - 1, 1);
        System.out.println(Arrays.toString(tree));
        updateRangeLazy(0, n - 1, 2, 4, 10, 1);
        System.out.println(Arrays.toString(tree));
        System.out.println(Arrays.toString(lazy));
        System.out.println(queryLazy(0,n-1,1,5,1));
    }
}