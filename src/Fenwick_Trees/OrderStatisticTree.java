/**
 * Order Statistic Tree is a special BIT which supports following 4 operations :
 * 1. insert(a) : O(log N)
 * 2. delete(a) : O(log N)
 * 3. getRank(a) : index of element in sorted array, O(log N)
 * 4. kthSmallest(k) : O(log N * log N)
 */
public class OrderStatisticTree {
    private static final int max = 1000000;
    private static int[] BIT = new int[max + 1];

    private static void insert(int a) {
        update(a, 1);
    }

    private static void delete(int a) {
        update(a, -1);
    }

    private static int getRank(int a) {
        return query(a);
    }

    private static int kthSmallest(int k) {
        int s = 0, e = max;
        while (s < e) {
            int m = (s + e) / 2;
            if (k <= query(m))
                e = m;
            else s = m + 1;
        }
        return e;
    }

    private static int query(int i) {
        int ans = 0;
        while (i > 0) {
            ans += BIT[i];
            i -= i & (-i);
        }
        return ans;
    }

    private static void update(int i, int v) {
        while (i <= max) {
            BIT[i] += v;
            i += i & (-i);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 9, 10, 8, 6, 96, 14, 70, 59};
        for (int i = 0; i < 10; i++)
            insert(a[i]);
        System.out.println(getRank(59));
        delete(6);
        System.out.println(getRank(59));
        System.out.println(kthSmallest(6));
    }
}