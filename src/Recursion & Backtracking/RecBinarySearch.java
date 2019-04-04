import java.util.Scanner;

public class RecBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i += 1) {
            a[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int res = search(a, key, 0, n - 1);
        if (res == -1)
            System.out.println("Not Found !");
        else
            System.out.println("Found at index " + res);
    }

    private static int search(int a[], int k, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == k)
                return mid;
            if (a[mid] > k)
                return search(a, k, low, mid - 1);
            else
                return search(a, k, mid + 1, high);
        }
        return -1;
    }
}