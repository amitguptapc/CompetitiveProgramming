import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class GameTheory3 {
    private static HashMap<Long, Long> memo = new HashMap<>();

    private static long findMex(TreeSet<Long> set) {
        long mex = 0;
        while (set.size() != 0 && set.first() == mex) {
            mex++;
            set.pollFirst();
        }
        return mex;
    }

    private static long findGrundy(long a) {
        if (a == 1)
            return 0;
        if (memo.containsKey(a))
            return memo.get(a);
        TreeSet<Long> set = new TreeSet<>();
        set.add(findGrundy(1));
        long g;
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                g = findGrundy(i);
                long nop = a / i; // number of piles
                if (nop % 2 == 0)
                    g = 0;
                set.add(g);
                if (i * i != a) {
                    g = findGrundy(a / i);
                    if (i % 2 == 0)
                        g = 0;
                    set.add(g);
                }
            }
        }
        memo.put(a, findMex(set));
        return memo.get(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] m = new long[n];
            long ans = 0;
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
                ans ^= findGrundy(m[i]);
            }
            System.out.println(ans == 0 ? 2 : 1);
        }
    }
}