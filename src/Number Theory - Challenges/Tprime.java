import java.util.Scanner;

// T prime no.s are no.s which are square of prime numbers
public class Tprime {
    private static int[] sieve(int n) {
        int[] a = new int[n + 1];
        a[2] = 1;
        for (int i = 3; i <= n; i += 2)
            a[i] = 1;
        for (int i = 3; i * i <= n; i += 2) {
            if (a[i] == 1)
                for (int j = i * i; j <= n; j += 2 * i)
                    a[j] = 0;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = sieve(1000000);
        while (n-- > 0) {
            long x = sc.nextLong();
            double m = Math.sqrt(x);
            if (m == (int) m && a[(int) m] == 1)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}