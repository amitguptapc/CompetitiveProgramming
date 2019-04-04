import java.util.Scanner;

// Requires application of Fermat's Little Theorem
public class LightsNewCar {
    private static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String a, b;
        while (t > 0) {
            a = sc.next();
            b = sc.next();
            long x = stringToLong(a, mod);
            long y = stringToLong(b, mod - 1);
            System.out.println(power(x, y, mod));
            t--;
        }
    }

    private static long stringToLong(String a, long m) {
        long ans = 0;
        int n = a.length();
        for (int i = 0; i < n; i++) {
            ans = (ans * 10) + (a.charAt(i) - '0');
            ans %= m;
        }
        return ans;
    }

    private static long power(long a, long b, long m) {
        if (b == 0)
            return 1;
        long sp = power(a, b / 2, m);
        sp %= m;
        sp = (sp * sp) % m;
        if ((b & 1) == 1) {
            return (a * sp) % m;
        }
        return sp;
    }
}