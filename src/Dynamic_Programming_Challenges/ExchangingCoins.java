import java.util.HashMap;
import java.util.Scanner;

public class ExchangingCoins {
    private static HashMap<Long, Long> map;

    private static long maxProfit(long n) {
        if (map.get(n) != null)
            return map.get(n);
        if (n < 12)
            return n;
        long x = maxProfit(n / 2) + maxProfit(n / 3) + maxProfit(n / 4);
        map.put(n, Math.max(x, n));
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        map = new HashMap<>();
        System.out.println(maxProfit(n));
    }
}