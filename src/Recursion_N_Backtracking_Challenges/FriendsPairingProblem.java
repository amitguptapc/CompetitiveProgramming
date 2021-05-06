import java.util.Scanner;

public class FriendsPairingProblem {
    private static long findWays(long n) {
        if (n == 1 || n == 2)
            return n;
        return findWays(n - 1) // remain single
                + (n - 1) * findWays(n - 2); // pair with any of the remaining n-1 people
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(findWays(n));
        }

    }
}