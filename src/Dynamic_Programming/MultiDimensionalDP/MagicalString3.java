package Dynamic_Programming.MultiDimensionalDP;

import java.util.Scanner;

public class MagicalString3 {
    private static char[] s;
    private static int[] f;
    private static int n;

    private static boolean isValid(int i, int j) {
        int l = j - i + 1;
        for (int x = i; x <= j; x++)
            if (f[s[x] - 'a'] < l)
                return false;
        return true;
    }

    private static int solve() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isValid(i, j))
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next().toCharArray();
        f = new int[26];
        for (int i = 0; i < 26; i++)
            f[i] = sc.nextInt();
        System.out.println(solve());
    }
}
