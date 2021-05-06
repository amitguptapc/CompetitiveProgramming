import java.text.DecimalFormat;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/846/F
public class RandomQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();
        int[] pos = new int[1000001];
        long[] dp = new long[n + 1];
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - pos[a[i]]);
            pos[a[i]] = i;
            sum += dp[i];
        }
        double ans = 2 * sum - n;
        ans /= Math.pow(n, 2);
        DecimalFormat df = new DecimalFormat("#0.000000");
        System.out.println(df.format(ans));
    }
}
