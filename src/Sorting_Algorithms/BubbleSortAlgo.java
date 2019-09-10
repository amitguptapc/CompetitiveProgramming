import java.util.Arrays;

public class BubbleSortAlgo {
    private static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {565, 8, 9, -56, 6626, 59, 59, 5698};
        bubbleSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}