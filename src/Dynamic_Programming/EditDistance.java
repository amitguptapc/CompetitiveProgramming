import java.util.Scanner;

public class EditDistance {
    private static int[][] memo;

    // convert r to s
    // Pure DP
    private static int editDist3(String r, String s) {
        int m = r.length(), n = s.length();
        for (int i = 0; i <= m; i++)
            memo[i][0] = i;
        for (int j = 0; j <= n; j++)
            memo[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (r.charAt(i - 1) == s.charAt(j - 1))
                    memo[i][j] = memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.min(memo[i - 1][j - 1], Math.min(memo[i][j - 1], memo[i - 1][j])) + 1;
            }
        }
        return memo[m][n];
    }

    // Memoization
    private static int editDist2(String r, String s) {
        int m = r.length(), n = s.length();
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (s.charAt(0) == r.charAt(0))
            memo[m][n] = editDist2(r.substring(1), s.substring(1));
        else {
            int x = editDist2(r.substring(1), s);
            int y = editDist2(r, s.substring(1));
            int z = editDist2(r.substring(1), s.substring(1));
            memo[m][n] = Math.min(x, Math.min(y, z)) + 1;
        }
        return memo[m][n];
    }

    // Naive
    private static int editDist1(String r, String s) {
        // convert r to s
        if (s.length() == 0)
            return r.length();
        if (r.length() == 0)
            return s.length();
        if (s.charAt(0) == r.charAt(0))
            return editDist1(r.substring(1), s.substring(1));
        int x = editDist1(r.substring(1), s); // deletion
        int y = editDist1(r, s.substring(1)); // insertion
        int z = editDist1(r.substring(1), s.substring(1)); // replacement
        return Math.min(x, Math.min(y, z)) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        String s = sc.next();
        int m = r.length(), n = s.length();
        memo = new int[m + 1][n + 1];
        for (int i = 0; i < (m + 1) * (n + 1); i++)
            memo[i / (n + 1)][i % (n + 1)] = -1;
        System.out.println(editDist3(r, s));
    }
}