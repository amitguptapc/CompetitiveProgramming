import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomizedQuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        shuffle(a, n);
        quickSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void shuffle(int[] a, int n) {
        Random ran = new Random();
        for (int i = n - 1; i > 0; i--) {
            int ri = ran.nextInt(i);
            int temp = a[i];
            a[i] = a[ri];
            a[ri] = temp;
        }
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end)
            return;
        int pivot = partition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int i = start - 1, pivot = a[end];
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[end];
        a[end] = a[i + 1];
        a[i + 1] = temp;
        return i + 1;
    }
}