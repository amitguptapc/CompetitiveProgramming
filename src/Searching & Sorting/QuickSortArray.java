import java.util.Arrays;

public class QuickSortArray {
    private static int partition(int[] a, int s, int e) {
        int i = s - 1, pivot = a[e];
        for (int j = s; j < e; j++) {
            if (a[j] < s) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[e];
        a[e] = temp;
        return i + 1;
    }

    private static void quickSort(int[] a, int s, int e) {
        if (s >= e)
            return;
        int m = partition(a, s, e);
        quickSort(a, s, m - 1);
        quickSort(a, m + 1, e);
    }

    public static void main(String[] args) {
        int[] a = {56, 1023, 32, 568, 142, 92, 4, 4563210, -2, -56986};
        int n = a.length;
        quickSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }
}