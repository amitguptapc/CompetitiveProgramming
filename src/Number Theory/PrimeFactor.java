import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> res = factor(num);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> sieve(int n) {
        int[] a = new int[n + 1];
        a[2] = 1;
        for (int i = 3; i <= n; i += 2)
            a[i] = 1;
        for (int i = 3; i <= n; i += 2) {
            if (a[i] == 1) {
                for (int j = i * i; j <= n; j += 2 * i)
                    a[j] = 0;
            }
        }
        ArrayList<Integer> val = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (a[i] == 1)
                val.add(i);
        return val;
    }

    private static ArrayList<Integer> factor(int num) {
        ArrayList<Integer> primes = sieve(num / 2);
        ArrayList<Integer> factors = new ArrayList<>();
        int p = primes.get(0);
        int i = 0;
        while (p * p <= num) {
            if (num % p == 0) {
                factors.add(p);
                num /= p;
            }
            if (num % p != 0)
                p = primes.get(++i);
        }
        if (num != 1)
            factors.add(num);
        return factors;
    }
}