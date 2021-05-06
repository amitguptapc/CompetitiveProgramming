import java.io.*;
import java.util.StringTokenizer;

// https://www.hackerearth.com/problem/algorithm/mancunian-and-factorization-game-b8794702/
// each prime factor is a pile with no of coins equal to the power of prime in whole array
// we have to reduce power to 0
public class FactorizationGame {
    private static int max = 1000000;
    private static int[] factor;

    private static void getFactors(int[] a, int n) {
        factor = new int[max + 1];
        for (int i : a) {
            while (i % 2 == 0) {
                i /= 2;
                factor[2]++;
            }
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                while (i % j == 0) {
                    i /= j;
                    factor[j]++;
                }
            }
            if (i != 1)
                factor[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());
            int ans = 0;
            getFactors(a, n);
            for (int i = 0; i < max; i++)
                ans ^= factor[i];
            if (ans == 0)
                bw.write("Liverbird\n");
            else bw.write("Mancunian\n");
        }
        bw.flush();
    }
}