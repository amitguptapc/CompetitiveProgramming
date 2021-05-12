import java.util.*;

// https://codeforces.com/problemset/problem/166/B
public class Polygons {
    static class Point implements Comparator<Point> {
        long x, y;

        Point() {
        }

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Point a, Point b) {
            if (a.x == b.x)
                return (int) (a.y - b.y);
            return (int) (a.x - b.x);
        }
    }

    private static long getOrientation(Point a, Point b, Point c) {
        return a.x * (c.y - b.y) + b.x * (a.y - c.y) + c.x * (b.y - a.y);
    }

    private static Set<Point> convexHull(ArrayList<Point> p, int n) {
        p.sort(new Point());
        Point p1 = p.get(0), pn = p.get(n - 1);
        ArrayList<Point> up = new ArrayList<>(), down = new ArrayList<>();
        up.add(p1);
        down.add(p1);
        for (int i = 1; i < n; i++) {
            long orientation = getOrientation(p1, p.get(i), pn);
            if (orientation >= 0) {
                while (up.size() >= 2 && getOrientation(up.get(up.size() - 2), up.get(up.size() - 1), p.get(i)) < 0)
                    up.remove(up.size() - 1);
                up.add(p.get(i));
            }
            if (orientation <= 0) {
                while (down.size() >= 2 && getOrientation(down.get(down.size() - 2), down.get(down.size() - 1), p.get(i)) > 0)
                    down.remove(down.size() - 1);
                down.add(p.get(i));
            }
        }

        Set<Point> hull = new HashSet<>(up);
        hull.addAll(down);
        return hull;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        HashSet<Point> map = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            points.add(new Point(sc.nextLong(), sc.nextLong()));
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            points.add(new Point(sc.nextLong(), sc.nextLong()));
            map.add(points.get(n + i));
        }

        Set<Point> hull = convexHull(points, n + m);
        for (Point p : hull) {
            if (map.contains(p)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}