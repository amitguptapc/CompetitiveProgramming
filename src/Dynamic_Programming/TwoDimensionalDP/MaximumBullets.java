package Dynamic_Programming.TwoDimensionalDP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://www.codechef.com/problems/LIONS
public class MaximumBullets {
    static class Bullets {
        int b1, b2;
    }

    private static int getMaxBullets(Bullets[] x, int n, int a, int b) {
        Arrays.sort(x, Comparator.comparingInt(o -> -Math.abs(o.b1) - o.b2));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (x[i].b1 >= x[i].b2 && a > 0) {
                ans += x[i].b1;
                a--;
            } else if (x[i].b2 >= x[i].b1 && b > 0) {
                ans += x[i].b2;
                b--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        Bullets[] x = new Bullets[n];
        for (int i = 0; i < n; i++) {
            x[i] = new Bullets();
            x[i].b1 = sc.nextInt();
        }
        for (int i = 0; i < n; i++)
            x[i].b2 = sc.nextInt();
        System.out.println(getMaxBullets(x, n, a, b));
    }
}
