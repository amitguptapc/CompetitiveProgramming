// given, there are 3 piles having 4, 6, 8 coins respectively.
// Players can reduce it to n/2 or n/3 or n/6,
// Find who wins using Sprague Grundy Theorem.
// A starts the game(Finder winner)

import java.util.TreeSet;

public class Game3 {
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
        s.add(findGrundy(n / 2));
        s.add(findGrundy(n / 3));
        s.add(findGrundy(n / 6));
        return findMex(s);
    }

    public static void main(String[] args) {
        int n = 4, m = 6, o = 8;
        int ans = findGrundy(4) ^ findGrundy(6) ^ findGrundy(8);
        if (ans == 0)
            System.out.println("B wins");
        else
            System.out.println("A wins");
    }
}