import java.util.Scanner;
import java.util.TreeSet;

// A pile of n coins. Min 1 and max 3 coins can be removed.
// Find who will win the game using Sprague Grundy Theorem.
// Finders winners game
// A starts the game.

public class Game2 {
    private static int findMex(TreeSet<Integer> s) {
        int c = 0;
        while (s.contains(c)) {
            c++;
        }
        return c;
    }

    private static int findGrundy(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 1; i <= 3; i++)
            s.add(findGrundy(n - i));
        return findMex(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = findGrundy(n);
        if (ans == 0)
            System.out.println("B wins");
        else
            System.out.println("A wins");
    }
}