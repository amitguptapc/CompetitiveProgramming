package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class RainWaterHarvesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(a[i], left[i - 1]);
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], a[i]);

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Math.min(right[i], left[i]) - a[i];
        System.out.println(ans);
    }
}
