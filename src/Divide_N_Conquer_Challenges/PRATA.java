package Divide_N_Conquer_Challenges;

import java.util.Arrays;
import java.util.Scanner;

public class PRATA {
    private static long paranthasMade(int a, long m) {
        //  solving quadratic equation
        long d = (long) Math.sqrt(a * a + 8 * a * m);
        d = d - a;
        d /= 2 * a;
        return d;
    }

    private static boolean isValid(int[] r, int l, long p, long time) {
        long count = 0;
        for (int i = 0; i < l; i++) {
            count += paranthasMade(r[i], time);
            if (count >= p)
                return true;
        }
        return false;
    }

    private static long timeReq(int[] r, int l, long p) {
        long s = 0, e = 4 * p * (p + 1), mid, ans = e;
        while (s <= e) {
            mid = (s + e) / 2;
            if (isValid(r, l, p, mid)) {
                e = mid - 1;
                ans = mid;
            } else s = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long p = sc.nextLong();
            int l = sc.nextInt();
            int[] r = new int[l];
            for (int i = 0; i < l; i++)
                r[i] = sc.nextInt();
            Arrays.sort(r);
            System.out.println(timeReq(r, l, p));
        }
    }
}