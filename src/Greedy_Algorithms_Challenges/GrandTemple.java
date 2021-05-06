import java.util.Arrays;
import java.util.Scanner;

public class GrandTemple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int dx = 0;
        int dy = 0;
        for (int i = 0; i < n - 1; i++) {
            dx = Math.max(dx, x[i + 1] - x[i] - 1);
            dy = Math.max(dy, y[i + 1] - y[i] - 1);
        }
        System.out.println(dx * dy);
    }
}