import java.util.Arrays;

public class InsertionSort {
    private static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {565, 8, 9, -56, 6626, 59, 59, 5698};
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}