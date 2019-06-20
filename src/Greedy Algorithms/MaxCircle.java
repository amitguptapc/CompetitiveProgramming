import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxCircle implements Comparator<MaxCircle.Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return o1.end - o2.end;
    }

    static class Circle {
        int start;
        int end;

        Circle(int c, int r) {
            start = c - r;
            end = c + r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Circle[] a = new Circle[n];
        for (int i = 0; i < n; i++) {
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            a[i] = new MaxCircle.Circle(l1, l2);
        }
        Arrays.sort(a, new MaxCircle());
        int c = 1, j = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].start >= a[j].end) {
                c++;
                j = i;
            }
        }
        System.out.println(n - c);
    }
}