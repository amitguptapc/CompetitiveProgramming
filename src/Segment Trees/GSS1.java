import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.spoj.com/problems/GSS1/
public class GSS1 {
    static class Node {
        long preSum;
        long sufSum;
        long totalSum;
        long maxSum;

        public Node() {

        }

        public Node(long ps, long ss, long ts, long ms) {
            preSum = ps;
            sufSum = ss;
            totalSum = ts;
            maxSum = ms;
        }
    }

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
        t.preSum = Math.max(left.preSum, left.totalSum + right.preSum);
        t.sufSum = Math.max(right.sufSum, left.sufSum + right.totalSum);
        t.totalSum = left.totalSum + right.totalSum;
        t.maxSum = Math.max(left.sufSum + right.preSum, Math.max(left.maxSum, right.maxSum));
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
        tree[index].preSum = Math.max(left.preSum, left.totalSum + right.preSum);
        tree[index].sufSum = Math.max(right.sufSum, left.sufSum + right.totalSum);
        tree[index].totalSum = left.totalSum + right.totalSum;
        tree[index].maxSum = Math.max(left.sufSum + right.preSum, Math.max(left.maxSum, right.maxSum));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(br.readLine().trim());
        int p = 4 * n + 1;
        tree = new Node[p];
        for (int i = 0; i < p; i++)
            tree[i] = new Node();
        buildTree(0, n - 1, 1);
        int x, y;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine().trim());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            System.out.println(query(0, n - 1, x - 1, y - 1, 1).maxSum);
        }
    }
}