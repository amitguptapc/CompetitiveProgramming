package Dynamic_Programming.MultiDimensionalDP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

// https://www.hackerearth.com/problem/algorithm/mancunian-and-k-ordered-lcs-e6a4b8c6/
public class KLCS {
    private static int[][][] dp;
    private static int[] a;
    private static int[] b;
    private static int n, m;

    private static int findKlcs(int i, int j, int k) {
        if (i >= n || j >= m) // any array is completed
            return 0;
        if (dp[i][j][k] != -1)
            return dp[i][j][k];
        int ans = 0;
        if (a[i] == b[j])
            ans = 1 + findKlcs(i + 1, j + 1, k);
        else {
            if (k > 0)
                ans = 1 + findKlcs(i + 1, j + 1, k - 1); // convert one element of array to match
            ans = Math.max(ans, findKlcs(i + 1, j, k));
            ans = Math.max(ans, findKlcs(i, j + 1, k));
        }
        return dp[i][j][k] = ans;
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        n = sc.si();
        m = sc.si();
        int k = sc.si();
        a = new int[n];
        b = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.si();
        for (int i = 0; i < m; i++)
            b[i] = sc.si();

        dp = new int[n + 1][m + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                for (int l = 0; l <= k; l++)
                    dp[i][j][l] = -1;

        pr.pl(findKlcs(0, 0, k));
        pr.close();
    }

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