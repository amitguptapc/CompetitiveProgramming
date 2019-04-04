import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GrahamScanAlgo implements Comparator<GrahamScanAlgo.Point> {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point start;

    private static double polarAngle(Point a) {
        return (1.0 * (start.y - a.y)) / (start.x - a.x);
    }

    public int compare(Point a, Point b) {
        double ans = polarAngle(a) - polarAngle(b);
        System.out.println(ans);
        if (ans > 0)
            return 1;
        else if (ans < 0)
            return -1;
        else return 0;
    }


    private static void convexHull(Point[] points, int n) {

        // finding the down most leftmost point
        Point startPoint = points[0];
        int min = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].y < startPoint.y || (points[i].y == startPoint.y && points[i].x < points[min].x)) {
                startPoint = points[i];
                min = i;
            }
        }
        start = startPoint;

        // sort the points according to polar angle wrt start point
        Arrays.sort(points, new GrahamScanAlgo());

        for (Point p : points)
            System.out.println(p.x + "," + p.y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++)
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        convexHull(points, n);
    }
}