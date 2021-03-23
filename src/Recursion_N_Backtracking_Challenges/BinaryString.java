import java.util.Scanner;

public class BinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        /*
          DP state are :
          1. length of String
          2. ending character
          dp[i][j] represents no of strings of length i with ending character j
         */
        long[][] dp = new long[91][2];
        dp[0][0] = dp[0][1] = 0;
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        while (t-- > 0) {
            n = sc.nextInt();
            System.out.println(dp[n][0] + dp[n][1]);
        }
    }
}