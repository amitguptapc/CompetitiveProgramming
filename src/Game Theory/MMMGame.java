import java.util.Scanner;

// https://www.spoj.com/problems/MMMGAME/
// Misere game
public class MMMGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int xor = 0;
            int ones = 0;
            int n = sc.nextInt();
            int a;
            for (int i = 0; i < n; i++) {
                a = sc.nextInt();
                xor ^= a;
                if (a == 1)
                    ones++;
            }
            if (ones == n) {
                if ((n & 1) == 1)
                    System.out.println("Brother");
                else System.out.println("John");
            } else System.out.println(xor == 0 ? "Brother" : "John");
        }
    }
}