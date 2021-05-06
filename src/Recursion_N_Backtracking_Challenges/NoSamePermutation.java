import java.util.Scanner;
import java.util.TreeSet;

public class NoSamePermutation {
    private static TreeSet<String> set;

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void permute(int[] a, int i, int n) {
        if (i == n) {
            String res = "";
            for (int k = 0; k < n; k++)
                res = res + a[k] + " ";
            set.add(res);
            return;
        }
        for (int j = i; j < n; j++) {
            swap(a, i, j);
            permute(a, i + 1, n);
            swap(a, i, j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        set = new TreeSet<>();
        permute(a, 0, n);
        for (String s : set)
            System.out.println(s);
    }
}