import java.util.Scanner;

public class InvCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(mergeSort(a, 0, n - 1));
        }
    }

    private static int mergeSort(int[] a, int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        return mergeSort(a, start, mid) +
                mergeSort(a, mid + 1, end) +
                merge(a, start, mid, end);
    }

    private static int merge(int[] a, int start, int mid, int end) {
        int count = 0;
        int n1 = mid - start + 1;
        int[] L = new int[n1];
        for (int i = 0; i < n1; i++)
            L[i] = a[start + i];
        int n2 = end - mid;
        int[] R = new int[n2];
        for (int i = 0; i < n2; i++)
            R[i] = a[mid + 1 + i];
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else {
                a[k++] = R[j++];
                count += n1 - i;
            }
        }
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
        return count;
    }
}