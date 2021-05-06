import java.util.Arrays;
import java.util.Scanner;

public class DividingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextLong();
            Arrays.sort(a);
            long max = 0, min = 0;
            int i = 0;
            while (i < n - 1) {
                min += Math.abs(a[i + 1] - a[i]);
                i += 2;
            }
            int j = n - 1;
            i = 0;
            while (i <= j)
                max += Math.abs(a[i++] - a[j--]);
            System.out.println(min + " " + max);
        }
    }
}