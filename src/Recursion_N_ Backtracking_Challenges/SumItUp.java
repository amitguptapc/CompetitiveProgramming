import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class SumItUp {
    private static TreeSet<String> set;

    private static void sumUpto(int[] a, int i, int n, int t, String r) {
        if (i >= n && t != 0)
            return;
        if (t == 0) {
            set.add(r);
            return;
        }
        if (a[i] <= t) {
            sumUpto(a, i + 1, n, t - a[i], r + a[i] + " ");
        }
        sumUpto(a, i + 1, n, t, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int t = sc.nextInt();
        Arrays.sort(a);
        set = new TreeSet<>();
        sumUpto(a, 0, n, t, "");
        for (String i : set)
            System.out.println(i);
    }
}