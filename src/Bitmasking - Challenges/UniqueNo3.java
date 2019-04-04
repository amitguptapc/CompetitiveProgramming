// https://hack.codingblocks.com/contests/c/366/458

import java.util.Scanner;

public class UniqueNo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(func(a, n));
    }

    private static int func(int a[], int n) {
        int b[] = new int[64];
        for (int i = 0; i < n; i++) {
            int j = 0, val = a[i];
            while (val > 0) {
                b[j] += (val & 1) == 1 ? 1 : 0;
                j++;
                val >>= 1;
            }
        }
        int ans = 0, p = 1;
        for (int i = 0; i < 64; i++) {
            b[i] %= 3;
            ans += b[i] * p;
            p <<= 1;
        }
        return ans;
    }
}