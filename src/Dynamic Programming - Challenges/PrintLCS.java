import java.util.Scanner;

public class PrintLCS {
    private static void printLCS(String r, String s) {
        int m = r.length(), n = s.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (r.charAt(i - 1) == s.charAt(j - 1))
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        int i = m, j = n;
        String res = "";
        while (i > 0 && j > 0) {
            if (r.charAt(i - 1) == s.charAt(j - 1)) {
                res = r.charAt(i - 1) + res;
                i--;
                j--;
            } else if (memo[i][j - 1] >= memo[i - 1][j])
                j--;
            else i--;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        String s = sc.next();
        printLCS(r, s);
    }
}