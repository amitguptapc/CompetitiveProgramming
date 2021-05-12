import java.util.*;

public class GrahamScanAlgo {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /*
    orientation < 0 : Counterclockwise
    orientation > 0 : Clockwise
    orientation = 0 : Collinear
    */
    private static int getOrientation(Point a, Point b, Point c) {
        return a.x * (c.y - b.y) + b.x * (a.y - c.y) + c.x * (b.y - a.y);
    }

    private static Set<Point> convexHull(Point[] p, int n) {
        if (n < 3)
            return null;

        // sort array according to x coordinates, if they are equal sort according to y coordinates
        Arrays.sort(p, (a, b) -> (a.x == b.x) ? (a.y - b.y) : (a.x - b.x));

        Point p1 = p[0], pn = p[n - 1];
        ArrayList<Point> up = new ArrayList<>(), down = new ArrayList<>();
        up.add(p1);
        down.add(p1);

        for (int i = 1; i < n; i++) {
            int orientation = getOrientation(p1, p[i], pn);
            // if point is in upper half
            if (orientation >= 0) { // orientation is clockwise or collinear
                while (up.size() >= 2 && getOrientation(up.get(up.size() - 2), up.get(up.size() - 1), p[i]) < 0)
                    up.remove(up.size() - 1);
                up.add(p[i]);
            }
            // if the point is in lower half
            if (orientation <= 0) { // orientation is counterclockwise or collinear
                while (down.size() >= 2 && getOrientation(down.get(down.size() - 2), down.get(down.size() - 1), p[i]) > 0)
                    down.remove(down.size() - 1);
                down.add(p[i]);
            }
        }

        Set<Point> hull = new HashSet<>(up);
        hull.addAll(down);
        return hull;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++)
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        Set<Point> hull = convexHull(points, n);
        assert hull != null;
        for (Point p : hull)
            System.out.println(p);
    }
}