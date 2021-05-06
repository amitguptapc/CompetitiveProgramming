import java.math.BigInteger;
import java.util.Scanner;

public class EvaluatingFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        BigInteger r = BigInteger.valueOf(4).multiply(x).multiply(x).multiply(x);
        BigInteger s = BigInteger.valueOf(5).multiply(x).multiply(x);
        BigInteger t = BigInteger.valueOf(6).multiply(x);
        BigInteger ans = r.add(s).subtract(t).add(BigInteger.valueOf(14));
        System.out.println(ans);
    }
}