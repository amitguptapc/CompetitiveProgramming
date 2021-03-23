import java.io.*;
import java.util.StringTokenizer;

// https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/shil-and-palindrome-research/
public class ShilAndPalindrome {
    private static long[][] BIT;
    private static int n;

    private static void update(int i, int k, int v) {
        while (i <= n) {
            BIT[i][k] += v;
            i += i & (-i);
        }
    }

    private static long query(int i, int k) {
        long ans = 0;
        while (i > 0) {
            ans += BIT[i][k];
            i -= i & (-i);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        BIT = new long[n + 1][26];
        String s = br.readLine();
        char[] carr = s.toCharArray();
        for (int i = 0; i < n; i++)
            update(i + 1, carr[i] - 'a', 1);
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int i = Integer.parseInt(st.nextToken());
                int c = st.nextToken().charAt(0) - 'a';
                update(i, carr[i - 1] - 'a', -1);
                carr[i - 1] = (char) (c + 'a');
                update(i, c, 1);
            } else {
                long odd = 0, x;
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for (int i = 0; i < 26; i++) {
                    x = query(r, i) - query(l - 1, i);
                    if (x % 2 == 1)
                        odd++;
                }
                if (odd <= 1)
                    bw.write("yes\n");
                else bw.write("no\n");
            }
        }
        bw.flush();
    }
}