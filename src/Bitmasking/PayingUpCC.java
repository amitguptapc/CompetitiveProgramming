// https://www.codechef.com/problems/MARCHA1

import java.util.Scanner;

public class PayingUpCC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(isPossible(a, n, m));
            t--;
        }
    }

    private static String isPossible(int a[], int n, int m) {
        int len = (1 << n) - 1;
        int val;
        for (int i = 0; i <= len; i++) {
            val = find(a, i);
            if (val == m) {
                return "Yes";
            }
        }
        return "No";
    }

    private static int find(int a[], int pos) {
        int sum = 0;
        int i = 0;
        while (pos > 0) {
            sum += (pos & 1) == 1 ? a[i] : 0;
            i++;
            pos >>= 1;
        }
        return sum;
    }
}