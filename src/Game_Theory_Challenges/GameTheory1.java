import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GameTheory1 {
    private static int findMex(Set<Integer> set) {
        int c = 0;
        while (set.contains(c)) {
            c++;
        }
        return c;
    }

    private static int findGrundy(int n) {
        if (n == 1)
            return 0;
        Set<Integer> set = new TreeSet<>();
        set.add(findGrundy(1));
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(findGrundy(i));
                if (i * i != n)
                    set.add(findGrundy(n / i));
            }
        }
        return findMex(set);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int g = findGrundy(m);
            if ((n & 1) == 0)
                g = 0;
            if (g == 0)
                System.out.println(2);
            else System.out.println(1);
        }
    }
}