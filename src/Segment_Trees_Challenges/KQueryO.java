import java.io.*;
import java.util.StringTokenizer;

public class KQueryO {
    private static int[] a;
    private static int[][] tree;

    private static int[] merge(int[] l, int[] r) {
        int n1 = l.length, n2 = r.length, i = 0, j = 0, k = 0;
        int[] a = new int[n1 + n2];
        while (i < n1 && j < n2)
            if (l[i] <= r[j])
                a[k++] = l[i++];
            else a[k++] = r[j++];
        while (i < n1)
            a[k++] = l[i++];
        while (j < n2)
            a[k++] = r[j++];
        return a;
    }

    private static int lowerBound(int[] a, int n, int k) {
        int s = 0, e = n - 1, ans = n;
        while (s <= e) {
            int m = (s + e) / 2;
            if (a[m] > k) {
                ans = m;
                e = m - 1;
            } else s = m + 1;
        }
        return ans;
    }

    private static int query(int s, int e, int qs, int qe, int k, int idx) {
        if (qe < s || qs > e)
            return 0;
        if (qs <= s && qe >= e) {
            int n = tree[idx].length;
            return n - lowerBound(tree[idx], n, k);
        }
        int m = (s + e) / 2;
        int l = query(s, m, qs, qe, k, 2 * idx);
        int r = query(m + 1, e, qs, qe, k, 2 * idx + 1);
        return l + r;
    }

    private static void build(int s, int e, int idx) {
        if (s == e) {
            tree[idx] = new int[]{a[s]};
            return;
        }
        int m = (s + e) / 2;
        build(s, m, 2 * idx);
        build(m + 1, e, 2 * idx + 1);
        tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        tree = new int[4 * n + 1][];
        build(0, n - 1, 1);
        int q = Integer.parseInt(br.readLine()), l, r, k;
        int lAns = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) ^ lAns;
            r = Integer.parseInt(st.nextToken()) ^ lAns;
            k = Integer.parseInt(st.nextToken()) ^ lAns;
            lAns = query(0, n - 1, l - 1, r - 1, k, 1);
            out.write(lAns + "\n");
        }
        out.flush();
    }
}