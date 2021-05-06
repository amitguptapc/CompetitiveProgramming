import java.util.Scanner;

public class PivotOfSorted {
    private static void findPivot(int[] a, int n) {
        int s = 0, e = n - 1, mid;
        while (s <= e) {
            mid = (s + e) / 2;
            if (mid > s && a[mid] < a[mid - 1]) {
                System.out.println(mid - 1);
                break;
            }
            if (mid < e && a[mid] > a[mid + 1]) {
                System.out.println(mid);
                break;
            }
            if (a[s] > a[mid])
                e = mid - 1;
            else s = mid + 1;
        }
        if (s > e)
            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        findPivot(a, n);
    }
}