import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Circle {
    long radius;
    long center;
    long start;
    long end;

    Circle(long c, long r) {
        center = c;
        radius = r;
        start = center - radius;
        end = center + radius;
    }

}

public class MaxCircles implements Comparator<Circle> {
    public int compare(Circle x, Circle y) {
        return (int) (x.end - y.end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Circle> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(new Circle(sc.nextLong(), sc.nextLong()));
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
}