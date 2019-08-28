import java.util.Arrays;

public class MergeSortArray {
    private static void merge(int[] a, int s, int m, int e) {
        int n1 = m - s + 1;
        int[] l = new int[n1];
        for (int i = 0; i < n1; i++)
            l[i] = a[i + s];
        int n2 = e - m;
        int[] r = new int[n2];
        for (int i = 0; i < n2; i++)
            r[i] = a[i + m + 1];
        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2) {
            if (l[i] < r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }
        while (i < n1)
            a[k++] = l[i++];
        while (j < n2)
            a[k++] = r[j++];
    }

    private static void mergeSort(int[] a, int s, int e) {
        if (s >= e)
            return;
        int m = (s + e) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m + 1, e);
        merge(a, s, m, e);
    }

    public static void main(String[] args) {
        int[] a = {56, 1023, 32, 568, 142, 92, 4, 4563210, -2, -56986};
        int n = a.length;
        mergeSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }
}