package Dynamic_Programming.OneDimensionalDP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Application of LIS
public class BoxStacking {
    static class Box {
        long l, b, h, area;

        public Box(long a, long b, long c) {
            this.l = Math.max(a, b);
            this.b = Math.min(a, b);
            this.h = c;
            area = this.l * this.b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a, b, c;
            Box[] boxes = new Box[3 * n];
            for (int i = 0; i < 3 * n; i += 3) {
                a = sc.nextLong();
                b = sc.nextLong();
                c = sc.nextLong();
                // considering all the rotations of box
                boxes[i] = new Box(a, c, b);
                boxes[i + 1] = new Box(b, a, c);
                boxes[i + 2] = new Box(c, b, a);
            }
            // Sorting all the box combinations according to base area
            Arrays.sort(boxes, Comparator.comparingLong(o -> o.area));

            long[] dp = new long[3 * n];
            for (int i = 0; i < 3 * n; i++)
                dp[i] = boxes[i].h;

            long ans = 0;
            for (int i = 1; i < 3 * n; i++) {
                for (int j = 0; j < i; j++) {
                    if (boxes[j].l < boxes[i].l && boxes[j].b < boxes[i].b)
                        dp[i] = Math.max(dp[j] + boxes[i].h, dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
            System.out.println(ans);
        }
    }
}
