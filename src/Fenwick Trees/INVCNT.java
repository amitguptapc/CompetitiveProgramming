import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Inversion Count
// https://www.spoj.com/problems/INVCNT/
public class INVCNT {
    private static int[] BIT;
    private static int[] a;

    private static int query(int i) {
        int ans = 0;
        while (i > 0) {
            ans += BIT[i];
            i -= (i & (-i));
        }
        return ans;
    }

    private static void update(int i, int inc) {
        while (i <= 2000001) {
            BIT[i] += inc;
            i += (i & (-i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            a = new int[n + 1];
            BIT = new int[2000002];
            for (int i = 1; i <= n; i++)
                a[i] = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = n; i >= 1; i--) {
                ans += query(a[i] - 1);
                update(a[i], 1);
            }
            System.out.println(ans);
            t--;
        }
    }
}