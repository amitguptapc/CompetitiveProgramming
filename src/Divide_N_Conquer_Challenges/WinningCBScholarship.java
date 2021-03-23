import java.util.Scanner;

public class WinningCBScholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long s = 0, mid, e = n, ans = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if (m + (n - mid) * y >= mid * x) {
                ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }
        System.out.println(ans);
    }
}