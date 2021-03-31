import java.util.Arrays;
import java.util.Scanner;

public class MinStepsTo1 {
    private static int[] memo;

    // Pure DP
    private static int reduce3(int n) {
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        int x, y, z;
        for (int i = 4; i <= n; i++) {
            x = Integer.MAX_VALUE;
            y = Integer.MAX_VALUE;
            if (i % 3 == 0)
                x = 1 + memo[i / 3];
            if (i % 2 == 0)
                x = 1 + memo[i / 2];
            z = 1 + memo[i - 1];
            memo[i] = Math.min(x, Math.min(y, z));
        }
        return memo[n];
    }

    // Memoization
    private static int reduce2(int n) {
        if (n == 1)
            return 0;
        if (memo[n] != -1)
            return memo[n];
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z;
        if (n % 3 == 0)
            x = 1 + reduce2(n / 3);
        if (n % 2 == 0)
            y = 1 + reduce2(n / 2);
        z = 1 + reduce2(n - 1);
        memo[n] = Math.min(x, Math.min(y, z));
        return memo[n];
    }

    // Naive
    private static int reduce1(int n) {
        if (n == 1)
            return 0;
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, z;
        if (n % 3 == 0) x = 1 + reduce1(n / 3);
        if (n % 2 == 0) y = 1 + reduce1(n / 2);
        z = 1 + reduce1(n - 1);
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(reduce3(n));
    }
}