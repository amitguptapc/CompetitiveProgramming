import java.util.Scanner;

public class FermatTest {
    private static int power(int a, int n, int p) {
        int res = 1;
        a %= p;
        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * a) % p;
            n >>= 1;
            a = (a * a) % p;
        }
        return res;
    }

    private static boolean isPrime(int n) {
        if (n <= 1 || n == 4) // edge cases
            return false;
        if (n <= 3)
            return true;
        int k = 5; // no of times the iteration must be performed
        while (k-- > 0) {
            int a = 2 + (int) (Math.random() % (n - 4));
            if (power(a, n - 1, n) != 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        System.out.println(isPrime(p));
    }
}