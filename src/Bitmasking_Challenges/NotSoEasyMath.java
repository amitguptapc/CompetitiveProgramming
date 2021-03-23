import java.util.Scanner;

// Based on Inclusion Exclusion Principle
public class NotSoEasyMath {
    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long ans = 0;
            int subsets = (1 << 8) - 1; // no of primes is 8
            for (int i = 1; i <= subsets; i++) {
                int setB = Integer.bitCount(i);
                long d = 1;
                for (int j = 0; j <= 7; j++) {
                    if ((i & (1 << j)) != 0)
                        d *= primes[j];
                }
                if ((setB & 1) == 1)
                    ans += n / d;
                else ans -= n / d;
            }
            System.out.println(ans);
        }
    }
}