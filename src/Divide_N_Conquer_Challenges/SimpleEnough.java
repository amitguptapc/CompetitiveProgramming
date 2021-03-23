import java.util.Scanner;

public class SimpleEnough {
    private static long getCountOf1s(long n, long s, long e, long l, long r) {
        if (l > e || r < s || s > e)
            return 0;
        long m = (s + e) / 2;
        long ans = 0;
        if (m >= l && m <= r && n % 2 == 1)
            ans++;
        ans += getCountOf1s(n / 2, s, m - 1, l, r);
        ans += getCountOf1s(n / 2, m + 1, e, l, r);
        return ans;
    }

    private static long countElements(long n) {
        if (n == 0 || n == 1)
            return 1;
        return countElements(n / 2) * 2 + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        long end = countElements(n);
        System.out.println(getCountOf1s(n, 1, end, l, r));
    }
}