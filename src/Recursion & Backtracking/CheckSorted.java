import java.util.Scanner;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(isSorted(a, n));
    }

    private static boolean isSorted(int a[], int n) {
        if (n == 1 || n == 0)
            return true;
        if (a[n - 1] < a[n - 2])
            return false;
        return isSorted(a, n - 1);
    }
}