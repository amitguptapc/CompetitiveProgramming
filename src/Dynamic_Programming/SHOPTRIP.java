import java.util.ArrayList;
import java.util.Scanner;

// variation of TSP
// https://www.codechef.com/problems/SHOPTRIP

public class SHOPTRIP {
    private static double[][] dist;
    private static int n, k;
    private static ArrayList<Integer> ingred;
    private static double[][] dp;

    private static double shopTrip(int mask, int ind) {
        // base case
        if (mask == ((1 << k) - 1) && ind == 0)
            return 0;

        if (dp[mask][ind] != -1)
            return dp[mask][ind];

        dp[mask][ind] = Double.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if ((mask | ingred.get(i)) > mask || i == 0)
                dp[mask][ind] = Math.min(
                        dp[mask][ind],
                        dist[ind][i] + shopTrip(mask | ingred.get(i), i)
                );
        }

        return dp[mask][ind];
    }

    private static double distance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();

            ArrayList<Point> coord = new ArrayList<>();
            coord.add(new Point(0, 0));  // kitchen coordinates

            for (int i = 0; i < n; i++)
                coord.add(new Point(sc.nextInt(), sc.nextInt()));

            ingred = new ArrayList<>();
            ingred.add(0); // ingredients in kitchen

            int ig, present = 0;
            for (int i = 0; i < n; i++) {
                ig = Integer.parseInt(sc.next(), 2);
                ingred.add(ig);
                present |= ig;
            }

            if (present != (1 << k) - 1) { // if any ingredient if missing in all shops
                System.out.println(-1);
                continue;
            }

            // maintain distance between all shops and kitchen
            dist = new double[n + 1][n + 1];
            for (int i = 0; i <= n; i++)
                for (int j = 0; j <= n; j++)
                    dist[i][j] = distance(coord.get(i), coord.get(j));

            dp = new double[1 << k][n + 1];
            for (int i = 0; i < (1 << k); i++)
                for (int j = 0; j <= n; j++)
                    dp[i][j] = -1;

            System.out.println(shopTrip(0, 0));
        }
    }

    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}