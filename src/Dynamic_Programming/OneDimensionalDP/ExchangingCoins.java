package Dynamic_Programming.OneDimensionalDP;

import java.util.*;

// https://www.hackerearth.com/practice/algorithms/dynamic-programming/state-space-reduction/practice-problems/algorithm/bytelandian-gold-coins/
// Based on state space reduction
public class ExchangingCoins {
    private static Map<Long, Long> map = new HashMap<>();

    private static long getMaxValue(long n) {
        if (n == 0)
            return 0;
        if (map.containsKey(n))
            return map.get(n);
        map.put(n, Math.max(n, getMaxValue(n / 3) + getMaxValue(n / 2) + getMaxValue(n / 4)));
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            System.out.println(getMaxValue(n));
        }
    }
}