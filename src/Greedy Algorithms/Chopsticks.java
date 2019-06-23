import java.util.Arrays;
import java.util.Scanner;

// https://www.codechef.com/problems/TACHSTCK
public class Chopsticks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        int i = 0;
        int pairs = 0;
        while (i < n - 1) {
            if (a[i + 1] - a[i] <= d) {
                i += 2;
                pairs++;
            } else i += 1;
        }
        System.out.println(pairs);
    }
}