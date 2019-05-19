package src.Mathematics;

import java.util.Scanner;

public class DivSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] prefixSum = new long[n];
            prefixSum[0] = 1;
            long num, sum = 0;
            for (int i = 0; i < n; i++) {
                num = sc.nextLong();
                sum += num;
                sum %= n;
                sum = (sum + n) % n;
                prefixSum[(int) sum]++;
            }
            long ans = 0;
            for (int i = 0; i < n; i++)
                ans += ((prefixSum[i] - 1) * prefixSum[i]) / 2;
            System.out.println(ans);
        }
    }
}