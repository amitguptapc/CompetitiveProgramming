import java.util.Scanner;

public class BookAllocation {
    private static boolean canDistribute(long[] p, int n, int m, long ans) {
        int noOfStudents = 1;
        long pages = 0;
        for (int i = 0; i < n; i++) {
            if (pages + p[i] > ans) {
                pages = p[i];
                noOfStudents++;
                if (noOfStudents > m)
                    return false;
            } else {
                pages += p[i];
            }
        }
        return true;
    }

    private static long search(long[] p, int n, int m) {
        long s = p[n - 1];
        long e = 0;
        for (long i : p)
            e += i;
        long mid, ans = s;
        while (s <= e) {
            mid = (s + e) / 2;
            if (canDistribute(p, n, m, mid)) {
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
        long[] p = new long[n];
        for (int i = 0; i < n; i++)
            p[i] = sc.nextLong();
        System.out.println(search(p, n, m));
    }
}