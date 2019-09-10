import java.util.Scanner;

public class MedianSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        System.out.println(median(a, b, n));
        /*    Naive approach

         ArrayList<Integer> a = new ArrayList<>();
         ArrayList<Integer> b = new ArrayList<>();
         for (int i = 0; i < n; i++)
         a.add(sc.nextInt());
         for (int i = 0; i < n; i++)
         b.add(sc.nextInt());
         a.addAll(b);
         Collections.sort(a);
         System.out.println((a.get(n) + a.get(n - 1)) / 2);
         */
    }

    // O(N)
    private static int median(int[] a, int[] b, int n) {
        int i = 0, j = 0, m1 = 0, m2 = 0;
        for (int k = 0; k <= n; k++) {
            if (i == n) {
                m1 = m2;
                m2 = b[0];
                break;
            }
            if (j == n) {
                m1 = m2;
                m2 = a[0];
                break;
            }
            if (a[i] < b[j]) {
                m1 = m2;
                m2 = a[i];
                i++;
            } else {
                m1 = m2;
                m2 = b[j];
                j++;
            }
        }
        return (m1 + m2) / 2;
    }
}