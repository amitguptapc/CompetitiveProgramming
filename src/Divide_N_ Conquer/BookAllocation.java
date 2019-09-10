import java.util.Scanner;

public class BookAllocation {
    private static boolean canDistribute(long[] a, int n, int m, long ans) {
        int stud = 1;
        long pages = 0;
        for (int i = 0; i < n; i++) {
            if (pages + a[i] > ans) {
                stud++;
                pages = a[i];
                if (stud > m)
                    return false;
            } else pages += a[i];
        }
        return true;
    }

    private static long allocateBooks(long[] a, int n, int m) {
        long s = a[n - 1], e = 0, mid;
        for (long i : a)
            e += i;
        long ans = s;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canDistribute(a, n, m, mid)) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLong();
        System.out.println(allocateBooks(a, n, m));
    }
} 
