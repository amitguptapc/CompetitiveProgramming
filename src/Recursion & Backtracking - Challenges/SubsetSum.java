import java.util.Scanner;

public class SubsetSum {
    private static boolean subsets(int[] a, int n, int i, int sum, int inc) {
        if (sum == 0 && inc != 0)
            return true;
        if (i == n) {
            return false;
        }
        return subsets(a, n, i + 1, sum, inc) || subsets(a, n, i + 1, sum + a[i], inc + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(subsets(a, n, 0, 0, 0) ? "Yes" : "No");
        }
    }
}