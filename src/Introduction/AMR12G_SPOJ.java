// https://www.spoj.com/problems/AMR12G/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AMR12G_SPOJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(s.nextToken());
            int m = Integer.parseInt(s.nextToken());
            int k = Integer.parseInt(s.nextToken());
            int count[] = new int[n];
            String board[] = new String[n];
            for (int i = 0; i < n; i++) {
                board[i] = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (board[i].charAt(j) == '*')
                        count[i]++;
                }
            }
            Arrays.sort(count);
            while (k > 0) {
                count[0] = m - count[0];
                Arrays.sort(count);
                k--;
            }
            int total = 0;
            for (int i = 0; i < n; i++)
                total += count[i];
            System.out.println(total);
            t--;
        }
    }
}