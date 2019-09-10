import java.util.HashMap;
import java.util.Scanner;

// O(log N)
public class EfficientFib {
    private static HashMap<Long, Long> dp = new HashMap<>();

    private static long fib(long n) {
        if (dp.get(n) != null)
            return dp.get(n);
        long k = n / 2;
        if (n % 2 == 0) // even case
            dp.put(n, fib(k) * fib(k) + fib(k - 1) * fib(k - 1));
        else // odd case
            dp.put(n, fib(k + 1) * fib(k) + fib(k - 1) * fib(k));
        return dp.get(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        dp.put(0L, 1L);
        dp.put(1L, 1L);
        System.out.println(n == 0 ? 0 : fib(n - 1));
    }
}