import java.util.Arrays;
import java.util.Scanner;

public class DefenseOfKingdom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long w = sc.nextInt();
            long h = sc.nextInt();
            int n = sc.nextInt();
            long[] x = new long[n];
            long[] y = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextLong();
                y[i] = sc.nextLong();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            if (n > 0) {
                long dx = Math.max(x[0] - 1, w - x[n - 1]);
                long dy = Math.max(y[0] - 1, h - y[n - 1]);
                for (int i = 0; i < n - 1; i++) {
                    dx = Math.max(dx, x[i + 1] - x[i] - 1);
                    dy = Math.max(dy, y[i + 1] - y[i] - 1);
                }
                System.out.println(dx * dy);
            } else System.out.println(w * h);
        }
    }
}