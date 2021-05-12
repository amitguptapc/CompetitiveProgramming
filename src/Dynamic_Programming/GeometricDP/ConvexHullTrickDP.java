package Dynamic_Programming.GeometricDP;

import java.util.Stack;

/*
Convex Hull Trick is basically a DP optimization technique
Template of Max Hull
Ref. https://codeforces.com/blog/entry/63823
*/
public class ConvexHullTrickDP {
    // line : y = mx + c
    static class Line {
        int m, c;

        Line(int a, int b) {
            m = a;
            c = b;
        }
    }

    private static Stack<Line> hull = new Stack<>(); // to store lines
    private static Stack<Double> POI = new Stack<>(); // to store the points of intersection

    private static double xIntersection(Line l1, Line l2) {
        if (l1.m == l2.m)
            return Integer.MAX_VALUE;
        else return (double) (l2.c - l1.c) / (double) (l1.m - l2.m);
    }

    private static int evaluate(int x, Line l) {
        return x * l.m + l.c;
    }

    private static void addLine(Line l) {
        if (hull.size() == 0) { // if hull is empty
            hull.push(l);
            return;
        }
        if (hull.size() == 1) { // if there is only 1 line in the hull
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

    private static int findBest(int x) {
        // finding the upper bound of x
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
}

