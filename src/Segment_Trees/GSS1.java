import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

// https://www.spoj.com/problems/GSS1/
public class GSS1 {
    private static long[] a;
    private static Node[] tree;

    private static Node query(int ns, int ne, int qs, int qe, int index) {
        if (qs <= ns && qe >= ne)
            return tree[index];
        if (ne < qs || ns > qe) {
            long min = Long.MIN_VALUE;
            return new Node(min, min, min, min);
        }
        int mid = (ns + ne) / 2;
        Node left = query(ns, mid, qs, qe, 2 * index);
        Node right = query(mid + 1, ne, qs, qe, 2 * index + 1);
        Node t = new Node();
        t.ps = Math.max(left.ps, left.ts + right.ps);
        t.ss = Math.max(right.ss, left.ss + right.ts);
        t.ts = left.ts + right.ts;
        t.ms = Math.max(left.ss + right.ps, Math.max(left.ms, right.ms));
        return t;
    }

    private static void buildTree(int s, int e, int index) {
        if (s == e) {
            tree[index] = new Node(a[s], a[s], a[s], a[s]);
            return;
        }
        int mid = (s + e) / 2;
        buildTree(s, mid, 2 * index);
        buildTree(mid + 1, e, 2 * index + 1);
        Node left = tree[2 * index];
        Node right = tree[2 * index + 1];
        tree[index].ps = Math.max(left.ps, left.ts + right.ps);
        tree[index].ss = Math.max(right.ss, left.ss + right.ts);
        tree[index].ts = left.ts + right.ts;
        tree[index].ms = Math.max(left.ss + right.ps, Math.max(left.ms, right.ms));
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        int n = sc.si();
        a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.sl();
        int m = sc.si();
        int p = 4 * n + 1;
        tree = new Node[p];
        for (int i = 0; i < p; i++)
            tree[i] = new Node();
        buildTree(0, n - 1, 1);
        int x, y;
        while (m-- > 0) {
            x = sc.si() - 1;
            y = sc.si() - 1;
            System.out.println(query(0, n - 1, x, y, 1).ms);
        }
    }

    static class Node {
        long ps, ss, ts, ms;

        public Node() {
        }

        public Node(long ps, long ss, long ts, long ms) {
            this.ps = ps;
            this.ss = ss;
            this.ts = ts;
            this.ms = ms;
        }
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

        int si() throws IOException {
            int integer = 0;
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
}
