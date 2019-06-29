import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Inversion Count
// https://www.spoj.com/problems/INVCNT/
public class INVCNT {
    private static int[] BIT;

    private static int query(int i) {
        int ans = 0;
        while (i > 0) {
            ans += BIT[i];
            i -= (i & (-i));
        }
        return ans;
    }

    private static void update(int i) {
        while (i <= 10000001) {
            BIT[i] += 1;
            i += (i & (-i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        br.readLine();
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            BIT = new int[10000001];
            for (int i = 1; i <= n; i++)
                a[i] = Integer.parseInt(br.readLine());
            br.readLine();
            int ans = 0;
            for (int i = n; i >= 1; i--) {
                ans += query(a[i] - 1);
                update(a[i]);
            }
            System.out.println(ans);
            t--;
        }
    }
}