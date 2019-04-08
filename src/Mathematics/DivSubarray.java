package src.Mathematics;

import java.util.Scanner;

public class DivSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            long preSum[] = new long[n + 1];
            preSum[0] = 1;
            long val;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                val = sc.nextInt();
                sum += val;
                sum %= n;
                sum = (sum + n) % n;
                preSum[(int) sum]++;
            }
            long res = 0;
            for (int i = 0; i <= n; i++) {
                res += (preSum[i] * (preSum[i] - 1)) / 2;
            }
            System.out.println(res);
            t--;
        }
    }
}