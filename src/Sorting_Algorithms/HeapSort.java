import java.util.Arrays;

public class HeapSort {
    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest])
            largest = l;
        if (r < n && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }

    private static void heapSort(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = {56, 1023, 32, 568, 142, 92, 4, 4563210, -2, -56986};
        int n = a.length;
        heapSort(a, n);
        System.out.println(Arrays.toString(a));
    }
}