package Mathematics;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

// ref book
public class DIVSUBS {

    // begin of solution
    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int t = sc.scanInt();
        while (t-- > 0) {
            int n = sc.scanInt();
            long[] prefixSum = new long[n];
            int[] pos = new int[n];
            prefixSum[0] = 1;
            pos[0] = 0;
            long num, sum = 0;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.scanLong();
            }
            for (int i = 0; i < n; i++) {
                num = a[i];
                sum += num;
                sum %= n;
                sum = (sum + n) % n;
                if (prefixSum[(int) sum] > 0) {
                    System.out.println(i - pos[(int) sum] + 1);
                    for (int j = pos[(int) sum] + 1; j <= i + 1; j++)
                        System.out.print(j + " ");
                    System.out.println();
                    break;
                }
                prefixSum[(int) sum]++;
                pos[(int) sum] = i + 1;
            }
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

        String scanString() throws IOException {
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

        int scanInt() throws IOException {
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

        long scanLong() throws IOException {
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

        private void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }

        void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        void close() throws IOException {
            bw.close();
        }

        void flush() throws IOException {
            bw.flush();
        }
    }
}