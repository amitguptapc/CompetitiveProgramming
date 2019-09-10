import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    private static boolean isPossible(int[] a, int n, int c, int mid) {
        int cow = 1, pos = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - pos >= mid) {
                cow++;
                pos = a[i];
                if (cow == c)
                    return true;
            }
        }
        return false;
    }

    private static int maxDist(int[] a, int n, int c) {
        int s = 0, e = a[n - 1], mid, ans = -1;
        while (s <= e) {
            mid = (s + e) / 2;
            if (isPossible(a, n, c, mid)) {
                if (mid > ans)
                    ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            System.out.println(maxDist(a, n, c));
        }
    }
}