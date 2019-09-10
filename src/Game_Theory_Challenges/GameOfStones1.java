import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class GameOfStones1 {
    private static HashMap<Integer, Integer> map;

    private static int findMex(TreeSet<Integer> s) {
        int mex = 0;
        while (s.size() != 0 && s.first() == mex) {
            s.pollFirst();
            mex++;
        }
        return mex;
    }

    private static int findGrundy(int n) {
        if (n == 0 || n == 1)
            return 0;
        if (n == 2 || n == 3 || n == 4)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(findGrundy(n - 2));
        set.add(findGrundy(n - 3));
        set.add(findGrundy(n - 5));
        map.put(n, findMex(set));
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            map = new HashMap<>();
            int n = sc.nextInt();
            if (findGrundy(n) == 0)
                System.out.println("Second");
            else System.out.println("First");
        }
    }
}