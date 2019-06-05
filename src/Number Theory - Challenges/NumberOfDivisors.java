import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NumberOfDivisors {
    private static long m = 1000000007;

    private static ArrayList<Integer> sieve(int n) {
        int[] a = new int[n + 1];
        for (int i = 3; i <= n; i += 2)
            a[i] = 1;
        a[2] = 1;
        for (int i = 3; i * i <= n; i += 2)
            if (a[i] == 1)
                for (int j = i * i; j <= n; j += 2)
                    a[j] = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (a[i] == 1)
                list.add(i);
        return list;
    }

    private static long divisor(int[] a, int n) {
        ArrayList<Integer> primes = sieve(10000000);
        long[] freq = new long[1000001];
        for (int i = 0; i < n; i++) {
            for (int j : primes)
                while (a[i] > 1 && a[i] % j == 0) {
                    a[i] /= j;
                    freq[j] = (freq[j] + 1) % m;
                }
            if (a[i] != 1)
                freq[a[i]] = (freq[a[i]] + 1) % m;
        }
        long ans = 1;
        for (long i : freq) {
            ans = (ans * ((i + 1) % m)) % m;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            System.out.println(divisor(a, n));
        }
    }
}