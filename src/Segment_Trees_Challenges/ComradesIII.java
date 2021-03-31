import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/comrades-iii/
public class ComradesIII {
    private static ArrayList<Integer>[] list;
    private static int[] tree, lazy;
    private static int[] enter, exit;
    private static int time = 0;

    // flattening the tree
    private static void dfs(int root, int parent) {
        enter[root] = ++time;
        for (int i = 0; i < list[root].size(); i++) {
            int child = list[root].get(i);
            if (child != parent) {
                dfs(child, root);
            }
        }
        exit[root] = time;
    }

    private static int query(int s, int e, int qs, int qe, int idx) {
        if (lazy[idx] != 0) {
            tree[idx] = lazy[idx] == 1 ? (e - s + 1) : 0;
            if (s != e) {
                lazy[2 * idx] = lazy[idx];
                lazy[2 * idx + 1] = lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (qs > e || qe < s)
            return 0;
        if (qs <= s && qe >= e)
            return tree[idx];
        int m = (s + e) / 2;
        int l = query(s, m, qs, qe, 2 * idx);
        int r = query(m + 1, e, qs, qe, 2 * idx + 1);
        return l + r;
    }

    // lazy value -1 means sleep, 1 means awake
    private static void update(int s, int e, int qs, int qe, int k, int idx) {
        if (lazy[idx] != 0) {
            tree[idx] = lazy[idx] == 1 ? (e - s + 1) : 0;
            if (s != e) {
                lazy[2 * idx] = lazy[idx];
                lazy[2 * idx + 1] = lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (qs > e || qe < s)
            return;
        if (qs <= s && qe >= e) {
            tree[idx] = k == 1 ? (e - s + 1) : 0;
            if (s != e) {
                lazy[2 * idx] = k;
                lazy[2 * idx + 1] = k;
            }
            return;
        }
        int m = (s + e) / 2;
        update(s, m, qs, qe, k, 2 * idx);
        update(m + 1, e, qs, qe, k, 2 * idx + 1);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    private static void build(int s, int e, int idx) {
        if (s == e) {
            tree[idx] = 1;
            return;
        }
        int m = (s + e) / 2;
        build(s, m, 2 * idx);
        build(m + 1, e, 2 * idx + 1);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        enter = new int[n + 1];
        exit = new int[n + 1];
        tree = new int[4 * n + 1];
        lazy = new int[4 * n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        int p, root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p = Integer.parseInt(st.nextToken());
            if (p == 0)
                root = i;
            else {
                list[p].add(i);
                list[i].add(p);
            }
        }
        dfs(root, 0);
        build(1, n, 1);
        int q = Integer.parseInt(br.readLine()), x, y;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (x == 1)
                update(1, n, enter[y] + 1, exit[y], 1, 1);
            else if (x == 2)
                update(1, n, enter[y] + 1, exit[y], -1, 1);
            else
                bw.write(query(1, n, enter[y] + 1, exit[y], 1) + "\n");
        }
        bw.flush();
    }
}