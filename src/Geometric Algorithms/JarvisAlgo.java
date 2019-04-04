import java.util.ArrayList;
import java.util.Scanner;

public class JarvisAlgo {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int alignment(Point p, Point q, Point r) {
        int n = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
        if (n == 0)
            return 0;
        else if (n > 0)
            return 2;
        else
            return 1;
    }

    private static void convexHull(Point[] points, int n) {
        int s = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[s].x)
                s = i;
        int p = s, q;
        ArrayList<Point> hull = new ArrayList<>();
        do {
            hull.add(points[p]);
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
                if (alignment(points[p], points[i], points[q]) == 1)
                    q = i;
            p = q;
        } while (p != s);
        System.out.println("Vertices of the Convex Hull are :");
        for (Point i : hull)
            System.out.println("(" + i.x + "," + i.y + ")");
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