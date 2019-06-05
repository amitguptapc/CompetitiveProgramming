import java.util.Scanner;

public class FriendsPairingProblem {
    private static long pairs(long n) {
        if (n == 1 || n == 2)
            return n;
        return pairs(n - 1) + (n - 1) * pairs(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(pairs(n));
        }

    }
}