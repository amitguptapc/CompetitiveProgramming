package Mathematics;

// https://www.spoj.com/problems/FAVDICE/

import java.text.DecimalFormat;
import java.util.Scanner;

// Coupon Collector Problem
public class FAVDICE {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            double ans = 0;
            for (int i = 1; i <= n; i++)
                ans += n / (i * 1.0);
            System.out.println(df.format(ans));
        }
    }
}
