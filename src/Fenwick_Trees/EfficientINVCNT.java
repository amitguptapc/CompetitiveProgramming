import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeSet;

// Using COORDINATE COMPRESSION
public class EfficientINVCNT {
    private static long[] BIT;
    private static int n;

    private static long query(int i) {
        long ans = 0;
        while (i > 0) {
            ans += BIT[i];
            i -= (i & (-i));
        }
        return ans;
    }

    private static void update(int i) {
        while (i <= n) {
            BIT[i] += 1;
            i += (i & (-i));
        }
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int t = sc.si();
        while (t > 0) {
            n = sc.si();
            long[] a = new long[n + 1];
            BIT = new long[n + 1];
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.si();
                set.add(a[i]);
            }
            int idx = 1;
            HashMap<Long, Integer> map = new HashMap<>();
            for (long i : set)
                map.put(i, idx++);
            int[] b = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                b[i] = map.get(a[i]);
            }
            long ans = 0;
            for (int i = n; i >= 1; i--) {
                ans += query(b[i] - 1);
                update(b[i]);
            }
            pr.pl(ans);
            t--;
        }
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