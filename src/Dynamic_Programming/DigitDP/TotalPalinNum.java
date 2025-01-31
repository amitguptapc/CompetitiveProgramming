package DigitDP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 07/10/19
 * Time : 1:02 AM
 * Problem Code : AOPN
 * Platform : CodeChef
 */

public class TotalPalinNum {

    private static long MOD = 1000000007;

    // begin of solution
    private static String s;
    private static long[][][][][][][] dp;

    private static void reset() {
        for (int i = 0; i < 19; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    for (int l = 0; l < 2; l++)
                        for (int m = 0; m < 2; m++)
                            for (int n = 0; n < 11; n++)
                                for (int o = 0; o < 11; o++)
                                    dp[i][j][k][l][m][n][o] = -1;
    }

    private static long solve(int pos, int tight, int odd, int even, int st, int last, int slast) {
        if (pos == s.length())
            return odd & even;
        if (dp[pos][tight][odd][even][st][last][slast] != -1)
            return dp[pos][tight][odd][even][st][last][slast];
        long ans = 0;
        int end = tight == 1 ? s.charAt(pos) - '0' : 9;
        if (st == 0) {
            ans += solve(pos + 1, tight & (s.charAt(pos) == '0' ? 1 : 0), odd, even, st, last, slast);
            for (int i = 1; i <= end; i++)
                ans += solve(pos + 1, tight & (i == end ? 1 : 0), odd, even, 1, i, slast);
        } else {
            for (int i = 0; i <= end; i++)
                ans += solve(pos + 1, tight & (i == end ? 1 : 0), odd | (i == slast ? 1 : 0), even | (i == last ? 1 : 0), 1, i, last);
        }
        return dp[pos][tight][odd][even][st][last][slast] = ans;
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int t = sc.si();
        while (t-- > 0) {
            String a = sc.s();
            String b = sc.s();
            dp = new long[19][2][2][2][2][11][11];
            s = b;
            reset();
            long ans = solve(0, 1, 0, 0, 0, 10, 10);
            reset();
            s = a;
            ans -= solve(0, 1, 0, 0, 0, 10, 10);
            pr.pl(ans);
        }
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