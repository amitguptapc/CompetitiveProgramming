// https://www.spoj.com/problems/QCJ3

import java.util.Scanner;

// n coins on index m represents n piles of height m
public class QCJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int[] a = new int[s];
            int ans = 0;
            for (int i = 0; i < s; i++) {
                a[i] = sc.nextInt();
                if ((a[i] & 1) == 1)
                    ans ^= i + 1;
            }
            System.out.println(ans == 0 ? "Hanks Wins" : "Tom Wins");
        }
    }
}