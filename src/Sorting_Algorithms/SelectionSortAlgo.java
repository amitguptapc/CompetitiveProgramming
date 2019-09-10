import java.util.Arrays;

public class SelectionSortAlgo {
    private static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx])
                    minIdx = j;
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {565, 8, 9, -56, 6626, 59, 59, 5698};
        selectionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}