import java.io.*;

public class StringGame {
    private static String solve(char[] a, int n) {
        int[] pre = new int[n]; // store xor from left to right
        int[] suf = new int[n]; // store xor from right to left
        int c1 = 1, c2 = 1;
        pre[0] = 1;
        suf[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1])
                pre[i] = pre[i - 1] ^ c1 ^ ++c1;
            else {
                pre[i] = pre[i - 1] ^ 1;
                c1 = 1;
            }
            if (a[n - i] == a[n - i - 1])
                suf[n - i - 1] = suf[n - i] ^ c2 ^ ++c2;
            else {
                suf[n - i - 1] = suf[n - i] ^ 1;
                c2 = 1;
            }
        }
        if (pre[n - 1] == 0) // B wins without breaking the string
            return "YES";

        for (int i = 0; i < n - 1; i++) {
            if ((pre[i] ^ suf[i + 1]) == 0)
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            bw.write(solve(s.toCharArray(), s.length()) + "\n");
        }
        bw.flush();
    }
}