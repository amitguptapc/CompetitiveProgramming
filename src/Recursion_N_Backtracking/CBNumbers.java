package Recursion_N_Backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 10/09/19
 * Time : 1:56 AM
 * Problem Code : CBNumbers
 * Platform : HACKERBLOCKS
 */

public class CBNumbers {

    private static long MOD = 1000000007;

    // begin of solution
    private static boolean checkCB(long n) {
        if (n <= 1)
            return false;
        int[] CB = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int i = 0; i < 10; i++) {
            if (n == CB[i])
                return true;
            else if (n % CB[i] == 0)
                return false;
        }
        return true;
    }

    private static boolean isValid(boolean[] valid, int i, int j) {
        for (int k = i; k < j; k++)
            if (valid[i])
                return false;
        return true;
    }

    private static long countNum(String s, int n) {
        long num, count = 0;
        boolean[] valid = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                num = Long.parseLong(s.substring(i, j + 1));
                if (checkCB(num) && isValid(valid, i, j + 1)) {
                    count++;
                    for (int k = i; k <= j; k++)
                        valid[k] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int n = sc.si();
        String s = sc.s();
        pr.pl(countNum(s, n));
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