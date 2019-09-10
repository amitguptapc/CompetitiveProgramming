import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class HOLI {
    private static ArrayList<Edge>[] list;
    private static boolean[] visited;
    private static int[] count;
    private static int ans;
    private static int n;

    private static int dfs(int node) {
        visited[node] = true;
        count[node] = 1;
        int l = list[node].size();
        for (int i = 0; i < l; i++) {
            int dd = list[node].get(i).dest;
            if (!visited[dd]) {
                count[node] += dfs(dd);
                int s = count[dd];
                int eCost = list[node].get(i).weight;
                ans += 2 * Math.min(s, n - s) * eCost;
            }
        }
        return count[node];
    }

    public static void main(String[] args) throws IOException {
        AmitScan sc = new AmitScan();
        AmitPrint pr = new AmitPrint();
        int t = sc.scanInt();
        int s, d, w, z = 1;
        while (t-- > 0) {
            ans = 0;
            n = sc.scanInt();
            list = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                list[i] = new ArrayList<>();
            visited = new boolean[n + 1];
            count = new int[n + 1];
            for (int i = 1; i < n; i++) {
                s = sc.scanInt();
                d = sc.scanInt();
                w = sc.scanInt();
                list[s].add(new Edge(d, w));
                list[d].add(new Edge(s, w));
            }
            dfs(1);
            System.out.println("Case #" + (z++) + ": " + ans);
        }
        pr.close();
    }

    static class Edge {
        int dest;
        int weight;

        Edge(int d, int w) {
            dest = d;
            weight = w;
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