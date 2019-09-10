import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MaxCircles implements Comparator<MaxCircles.Circle> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Circle> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            a.add(new Circle(l1, l2));
        }
        a.sort(new MaxCircles());
        int c = 1, j = 0;
        for (int i = 1; i < n; i++) {
            if (a.get(i).start >= a.get(j).end) {
                c++;
                j = i;
            }
        }
        System.out.println(n - c);
    }

    public int compare(Circle x, Circle y) {
        return x.end - y.end;
    }

    static class Circle {
        int radius;
        int center;
        int start;
        int end;

        Circle(int c, int r) {
            center = c;
            radius = r;
            start = center - radius;
            end = center + radius;
        }
    }
}