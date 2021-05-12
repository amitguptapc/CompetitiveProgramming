package Dynamic_Programming.GeometricDP;

import java.util.Scanner;
import java.util.Stack;

// https://codeforces.com/problemset/problem/660/F
public class BearAndBowling4 {
    private static int n;
    private static long[] a, pre, sum;

    static class Line {
        long m, c;

        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }
    }

    private static Stack<Line> hull = new Stack<>();
    private static Stack<Double> POI = new Stack<>();

    private static double xIntersection(Line l1, Line l2) {
        if (l1.m == l2.m)
            return Integer.MAX_VALUE;
        else return (double) (l2.c - l1.c) / (double) (l1.m - l2.m);
    }

    private static long evaluate(long x, Line l) {
        return x * l.m + l.c;
    }

    private static void addLine(Line l) {
        if (hull.size() == 0) {
            hull.push(l);
            return;
        }
        if (hull.size() == 1) {
            POI.push(xIntersection(l, hull.peek()));
            hull.push(l);
            return;
        }
        while (!POI.isEmpty()) {
            Line l2 = hull.pop();
            Line l1 = hull.peek();
            if (xIntersection(l, l1) > POI.peek()) {
                hull.push(l2);
                break;
            } else POI.pop();
        }
        POI.push(xIntersection(l, hull.peek()));
        hull.push(l);
    }

    private static long findBest(long x) {
        int s = 0, e = POI.size() - 1, m, idx = e + 1;
        while (s <= e) {
            m = (s + e) / 2;
            if (POI.get(m) >= x) {
                idx = m;
                e = m - 1;
            } else
                s = m + 1;
        }
        return evaluate(x, hull.get(idx));
    }

    /*
    for any range (l,r] the ans is :
    y = pre[r] - pre [l] - (sum[r]-sum[l])*l
    Equation of line : y = mx + c
    here m = i , x = -sum[i], c = i*sum[i] - pre[i]
    the term pre[i] is constant for a particular iteration so added after getting the best match
    */
    private static long solve() {
        addLine(new Line(0, 0));
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, findBest(-sum[i]) + pre[i]);
            addLine(new Line(i, i * sum[i] - pre[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new long[n + 1];
        pre = new long[n + 1];
        sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            pre[i] = i * a[i] + pre[i - 1];
            sum[i] = a[i] + sum[i - 1];
        }
        System.out.println(solve());
    }
}