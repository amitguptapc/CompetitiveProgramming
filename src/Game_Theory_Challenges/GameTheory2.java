import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class GameTheory2 {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    private static int findMex(TreeSet<Integer> set) {
        int mex = 0;
        while (set.size() != 0 && set.first() == mex) {
            mex++;
            set.pollFirst();
        }
        return mex;
    }

    private static int findGrundy(int a) {
        if (a == 1)
            return 0;
        if (memo.containsKey(a))
            return memo.get(a);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(findGrundy(1));
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                set.add(findGrundy(i));
                if (i * i != a)
                    set.add(findGrundy(a / i));
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
            int[] m = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
                ans ^= findGrundy(m[i]);
            }
            System.out.println(ans == 0 ? 2 : 1);
        }
    }
}