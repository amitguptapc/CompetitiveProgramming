import java.util.Scanner;

public class LIS {
    private static int findLCS(int[] a, int n) {
        int[] memo = new int[n];            // here memo[i] stores the longest increasing subsequence
        for (int i = 0; i < n; i++)         // ending at that index
            memo[i] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    int temp = 1 + memo[j];
                    memo[i] = Math.max(temp, memo[i]);
                }
            }
            ans = Math.max(ans, memo[i]);
        }
        return ans;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(findLCS(a, n));
    }
}