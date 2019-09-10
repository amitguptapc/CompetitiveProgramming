import java.util.Scanner;

public class MathDay {
    private static long calculate(long a, long n, long p) {
        if (n == 1)
            return a;
        long ans = calculate(a, n / 2, p);
        if ((n & 1) == 0)
            ans = ((ans * ans) % p * a) % p;
        else ans = (ans * ans) % p;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a, n, p;
            a = sc.nextLong();
            n = sc.nextLong();
            p = sc.nextLong();
            for (int i = 1; i <= n; i++) {
                a = calculate(a, i, p) % p;
            }
            System.out.println(a);
        }
    }
}