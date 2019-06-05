import java.util.Scanner;

public class Totient {
    private static int totient(int n) {
        double ans = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                ans *= (1.0 - (1.0 / i));
            }
        }
        if (n != 1)
            ans *= (1.0 - (1.0 / n));
        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(totient(sc.nextInt()));
    }
}