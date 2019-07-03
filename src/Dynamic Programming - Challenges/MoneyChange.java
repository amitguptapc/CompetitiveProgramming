import java.util.Scanner;

public class MoneyChange {
    private static int no = 0;

    private static void noOfWays(int[] a, int n, int k) {
        if (k == 0) {
            no++;
            return;
        }
        if (k < 0)
            return;
        for (int i = 0; i < n; i++) {
            if (a[i] <= k)
                noOfWays(a, n, k - a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            no = 0;
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int k = sc.nextInt();
            noOfWays(a, n, k);
            System.out.println(no);
        }
    }
}