import java.util.Scanner;

public class RahulSearch {
    private static int search(int[] a, int s, int e, int key) {
        if (s > e)
            return -1;
        int mid = (s + e) / 2;
        if (a[mid] == key)
            return mid;
        if (a[s] <= a[mid]) {
            if (key <= a[mid] && key >= a[s])
                return search(a, s, mid - 1, key);
            else
                return search(a, mid + 1, e, key);
        }
        if (key >= a[mid] && key <= a[e])
            return search(a, mid + 1, e, key);
        return search(a, s, mid - 1, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(search(a, 0, n - 1, m));
    }
}