import java.util.Scanner;

public class RangeSumQuery {
    private static int query(int[] a, int[] blocks, int l, int r, int rn) {
        int ans = 0;

        // left part
        while (l < r && l % rn != 0)
            ans += a[l++];

        // middle part
        while (l + rn <= r) {
            ans += blocks[l / rn];
            l += rn;
        }

        //right part
        while (l <= r)
            ans += a[l++];

        return ans;
    }

    private static void update(int[] a, int[] blocks, int pos, int val, int rn) {
        blocks[pos / rn] += val - a[pos];
        a[pos] = val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int rn = (int) Math.sqrt(n);
        int[] blocks = new int[(int) Math.ceil((n * 1.0) / rn)];
        int bid = -1;

        // building the block array
        for (int i = 0; i < n; i++) {
            if (i % rn == 0)
                bid++;
            blocks[bid] += a[i];
        }
        System.out.println(query(a, blocks, 1, 8, rn));
        update(a, blocks, 3, 20, rn);
        System.out.println(query(a, blocks, 1, 8, rn));
    }
}