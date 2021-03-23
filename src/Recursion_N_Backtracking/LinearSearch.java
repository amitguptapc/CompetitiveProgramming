import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int key = sc.nextInt();
        int res = search(a, n, key);
        if (res == -1)
            System.out.println("Not Found !");
        else
            System.out.println("Found at index " + res);
    }

    private static int search(int[] a, int n, int k) {
        if (n < 1)
            return -1;
        if (a[n - 1] == k)
            return n - 1;
        return search(a, n - 1, k);
    }
}