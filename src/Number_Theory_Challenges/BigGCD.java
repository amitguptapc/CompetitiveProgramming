import java.math.BigInteger;
import java.util.Scanner;

public class BigGCD {
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO))
            return a;
        return gcd(b, a.mod(b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        System.out.println(gcd(a, b));
        // can also use inbuilt gcd function of BigInteger class
    }
}