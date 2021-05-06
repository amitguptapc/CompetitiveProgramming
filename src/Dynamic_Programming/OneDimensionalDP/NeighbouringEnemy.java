package Dynamic_Programming.OneDimensionalDP;

import java.util.Scanner;

public class NeighbouringEnemy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100001];
        for (int i = 0; i < n; i++)
            a[sc.nextInt()]++;
        for (int i = 2; i <= 100000; i++)
            a[i] = Math.max(a[i - 2] + i * a[i], a[i - 1]);
        System.out.println(a[100000]);
    }
}
