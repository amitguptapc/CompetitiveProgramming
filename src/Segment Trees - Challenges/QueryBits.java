import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class QueryBits {
    private static int[] tree, lazy;

    // begin of solution
    private static int queryLazy(int ns, int ne, int qs, int qe, int index) {
        // if lazy value present resolve it
        if (lazy[index] != -1) {
            tree[index] = lazy[index];
            // if it is not a leaf node
            if (ns != ne) {
                lazy[2 * index] = lazy[index];
                lazy[2 * index + 1] = lazy[index];
            }
            lazy[index] = -1;
        }
        // no overlap
        if (qs > ne || qe < ns)
            return Integer.MAX_VALUE;
        // complete overlap
        if (qs <= ns && qe >= ne) {
            return tree[index];
        }
        // partial overlap
        int mid = (ns + ne) / 2;
        int left = queryLazy(ns, mid, qs, qe, 2 * index);
        int right = queryLazy(mid + 1, ne, qs, qe, 2 * index + 1);
        return 2 * left + right;
    }

    private static void updateRangeLazy(int s, int e, int l, int r, int inc, int index) {
        // when current node already has some lazy value
        // resolve it and pass lazy value to children
        if (lazy[index] != -1) {
            tree[index] = lazy[index];
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] = lazy[index];
                lazy[2 * index + 1] = lazy[index];
            }
            lazy[index] = -1;
        }
        // no overlap case (out of bounds)
        if (s > r || l > e)
            return;
        // complete overlap
        if (l <= s && r >= e) {
            tree[index] = inc;
            // if it is not a leaf node
            if (s != e) {
                lazy[2 * index] = inc;
                lazy[2 * index + 1] = inc;
            }
            return;
        }
        // partial overlap
        int mid = (s + e) / 2;
        updateRangeLazy(s, mid, l, r, inc, 2 * index);
        updateRangeLazy(mid + 1, e, l, r, inc, 2 * index + 1);
        tree[index] = 2 * tree[2 * index] + tree[2 * index + 1];
    }


    private static void build(int[] a, int s, int e, int[] tree, int index) {
        // base case
        if (s == e) {
            tree[index] = a[s];
            return;
        }
        int mid = (s + e) / 2;
        build(a, s, mid, tree, 2 * index);
        build(a, mid + 1, e, tree, 2 * index + 1);
        tree[index] = 2 * tree[2 * index] + tree[2 * index + 1];
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int n = sc.si();
        int q = sc.si();
        int[] a = new int[n];
        tree = new int[4 * n + 1];
        lazy = new int[4 * n + 1];
        Arrays.fill(lazy,-1);
        build(a, 0, n - 1, tree, 1);
        int x, y, z;
        while (q-- > 0) {
            x = sc.si();
            y = sc.si();
            z = sc.si();
            if (x == 1 || x == 0)
                updateRangeLazy(0, n - 1, y, z, x, 1);
            else
                pr.pl(queryLazy(0, n - 1, y, z, 1));
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