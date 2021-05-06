import java.util.Scanner;

// https://www.spoj.com/problems/QCJ3
// n coins on index m represents n piles of height m
public class QCJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int ans = 0, a;
            for (int i = 1; i <= s; i++) {
                a = sc.nextInt();
                if ((a & 1) == 1)
                    ans ^= i;
            }
            System.out.println(ans == 0 ? "Hanks Wins" : "Tom Wins");
        }
    }
}