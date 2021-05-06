package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class OneCount {
    private static int n;
    private static int[] a;

    private static int oneCount(int i, int k) {
        if (i == n)
            return 0;
        int x, y, z;
        x = y = z = 0;
        if (a[i] == 1)
            x = 1 + oneCount(i + 1, k);
        else {
            if (k > 0)
                y = 1 + oneCount(i + 1, k - 1);
            else
                z = oneCount(i + 1, k);
        }
        return Math.max(x, Math.max(y, z));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(oneCount(0, k));
    }
}