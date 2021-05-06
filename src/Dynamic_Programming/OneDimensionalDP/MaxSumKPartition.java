package Dynamic_Programming.OneDimensionalDP;

import java.io.*;
import java.util.StringTokenizer;

// https://www.codechef.com/problems/JCWC00
public class MaxSumKPartition {
    private static long findMaxSum(long[] a, int n, int k) {
        long max1 = 0, max2 = 0, nmax1 = 0, nmax2 = 0;
        int maxIdx = 0, nmaxIdx = 0;
        long sum;
        for (int i = 0; i < n; i++) {
            if (i - maxIdx == k)
                sum = a[i] + max2;
            else sum = a[i] + max1;

            if (sum >= nmax1) {
                nmax2 = nmax1;
                nmax1 = sum;
                nmaxIdx = i;
            } else if (sum >= nmax2)
                nmax2 = sum;

            if ((i + 1) % k == 0) {
                max1 = nmax1;
                max2 = nmax2;
                maxIdx = nmaxIdx;
            }
        }
        return nmax1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Long.parseLong(st.nextToken());
            bw.write(findMaxSum(a, n, k) + "\n");
        }
        bw.flush();
    }
}