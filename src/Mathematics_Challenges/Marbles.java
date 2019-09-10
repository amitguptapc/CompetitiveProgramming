import java.math.BigInteger;
import java.util.Scanner;

public class Marbles {
    // example of Stars and Bars
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long p;
            p = (n - k) < (k - 1) ? (n - k) : (k - 1);
            n -= 1;
            // find C(n,p)
            BigInteger ans = BigInteger.ONE;
            for (int i = 0; i < p; i++)
                ans = ans.multiply(new BigInteger("" + (n - i))).divide(new BigInteger("" + (i + 1)));
            System.out.println(ans);
        }
    }
}