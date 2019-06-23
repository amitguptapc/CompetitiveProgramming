import java.util.Scanner;
import java.util.TreeSet;

// give a pile of n coins and the player can remove any no of coins.

public class GrundyNo {
    private static int findMex(TreeSet<Integer> s) {
        int c = 0;
        while (s.size() != 0 && s.first() == c) {
            c++;
            s.pollFirst();
        }
        return c;
    }

    private static int findGrundy(int n) {
        if (n == 0)
            return 0;
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 1; i <= n; i++)
            s.add(findGrundy(n - i));
        return findMex(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findGrundy(n));
    }
}