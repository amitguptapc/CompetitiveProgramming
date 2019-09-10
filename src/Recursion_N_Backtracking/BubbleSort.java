import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {5, 9, 8, 1, 3, 2};
        bubbleSort1(a, a.length);
        bubbleSort2(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort1(int a[], int n) {
        if (n == 1)
            return;
        for (int i = 0; i <= n - 2; i++)
            if (a[i] > a[i + 1]) {

                // swapping a[i] and a[i+1]
                int temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;

            }
        bubbleSort1(a, n - 1);
    }

    private static void bubbleSort2(int a[], int j, int n) {
        if (n == 1)
            return;
        if (j == n - 1) {
            bubbleSort2(a, 0, n - 1);
            return;
        }
        if (a[j] > a[j + 1]) {

            // swapping a[j] and a[j+1]
            int temp = a[j + 1];
            a[j + 1] = a[j];
            a[j] = temp;

        }
        bubbleSort2(a, j + 1, n);
    }
}