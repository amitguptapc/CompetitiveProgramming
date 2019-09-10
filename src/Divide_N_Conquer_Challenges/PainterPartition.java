import java.util.Scanner;

public class PainterPartition {
    private static boolean isPossible(int[] a, int n, int k, int val) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + a[i] <= val) {
                sum += a[i];
            } else {
                sum = a[i];
                count++;
                if (count > k)
                    return false;
            }
        }
        return true;
    }

    private static int minTime(int[] a, int n, int k) {
        int s = 0, e = 0, mid, ans = 0;
        for (int i = 0; i < n; i++) {
            e += a[i];
            s = a[i] > s ? a[i] : s;
        }
        while (s <= e) {
            mid = (s + e) / 2;
            if (isPossible(a, n, k, mid)) {
                ans = mid;
                e = mid - 1;
            } else s = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(minTime(a, n, k));
    }
}