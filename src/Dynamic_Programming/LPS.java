package Dynamic_Programming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 12/09/19
 * Time : 10:41 PM
 * Problem Code : LPS
 * Platform : NA
 */

public class LPS {
    // Longest Palindromic Subsequence
    private static long MOD = 1000000007;
    // begin of solution

    // DP
    private static int lps2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int k;
        for (int i = 0; i < n; i++) {
            k = 0;
            for (int j = i; j < n; j++, k++) {
                if (k == j)
                    dp[k][j] = 1;
                else if (s.charAt(k) == s.charAt(j) && k + 1 == j)
                    dp[k][j] = 2;
                else if (s.charAt(k) == s.charAt(j))
                    dp[k][j] = dp[k + 1][j - 1] + 2;
                else dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j]);
            }
        }
        return dp[0][n - 1];
    }

    // brute force
    private static int lps1(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j) // when length of string is 1
            return 1;
        if (s.charAt(i) == s.charAt(j))
            return lps1(s, i + 1, j - 1) + 2;
        return Math.max(lps1(s, i, j - 1), lps1(s, i + 1, j));
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        String s = sc.s();
//        pr.pl(lps1(s, 0, s.length() - 1));
        pr.pl(lps2(s));
        pr.close();
    }
    // end of solution

    static class AmitScan {
        private byte[] buf = new byte[1024]; // Buffer of Bytes
        private int index;
        private InputStream in;
        private int total;

        AmitScan() {
            in = System.in;
        }

        private int scan() throws IOException // Scan method used to scan buf
        {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        String s() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = scan();
            }
            return sb.toString();
        }

        int si() throws IOException {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) // Removing starting whitespaces
                n = scan();
            int neg = 1;
            if (n == '-') // If Negative Sign encounters
            {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
            return neg * integer;
        }

        long sl() throws IOException {
            long integer = 0;
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
        }
    }

    static class AmitPrint {
        private final BufferedWriter bw;

        AmitPrint() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        private void p(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }

        void pl(Object object) throws IOException {
            p(object);
            bw.append("\n");
        }

        void close() throws IOException {
            bw.close();
        }

        void f() throws IOException {
            bw.flush();
        }
    }
}