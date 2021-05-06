import java.util.Scanner;

public class TilingProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m;
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            System.out.println(waysOfTiling(n, m));
        }
    }

    private static int waysOfTiling(int n, int m) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i < m)
                ans[i] = 1;
            else if (i > m)
                ans[i] = (ans[i - 1] + ans[i - m]) % 1000000007;
            else
                ans[i] = 2;
        }
        return ans[n];
    }
}