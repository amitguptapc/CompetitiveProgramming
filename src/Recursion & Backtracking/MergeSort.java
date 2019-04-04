import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        mergeSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int a[], int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int a[], int start, int mid, int end) {
        // left subarray
        int n1 = mid - start + 1;
        int L[] = new int[n1];
        for (int i = 0; i < n1; i++)
            L[i] = a[start + i];

        // right subarray
        int n2 = end - mid;
        int R[] = new int[n2];
        for (int i = 0; i < n2; i++)
            R[i] = a[mid + 1 + i];

        // i is pointer for left subarray, j is for right subarray and k for main array
        int i = 0, j = 0, k = start;

        // merging the two sub arrays in ascending order
        while (i < n1 && j < n2) {
            if (L[i] < R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }

        // if some element of left subarray is remaining
        while (i < n1)
            a[k++] = L[i++];

        // if some element of right subarray is remaining
        while (j < n2)
            a[k++] = R[j++];
    }
}