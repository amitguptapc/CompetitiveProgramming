import java.util.Arrays;
import java.util.Scanner;

// Prefix maximum Element using Fenwick Tree
public class PreMaxElement {
    private static int[] BIT;
    private static int n;

    private static int query(int i) {
        int ans = Integer.MIN_VALUE;
        while (i > 0) {
            ans = Math.max(ans, BIT[i]);
            i -= (i & (-i));
        }
        return ans;
    }

    private static void update(int i, int val) {
        while (i <= n) {
            BIT[i] = Math.max(BIT[i], val);
            i += (i & (-i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        BIT = new int[n + 1];
        Arrays.fill(BIT, Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++)
            update(i, sc.nextInt());
        int q = sc.nextInt();
        update(3, 5);
        while (q > 0) {
            System.out.println(query(sc.nextInt()));
            q--;
        }
    }
}