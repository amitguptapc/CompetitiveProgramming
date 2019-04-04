import java.math.BigInteger;

public class BigIntDemo {
    private static BigInteger bigFac(int num) {
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= num; i++)
            b = b.multiply(BigInteger.valueOf(i));
        return b;
    }

    public static void main(String[] args) {

        // creating bigint object
        BigInteger b1 = new BigInteger("1001100", 2);
        BigInteger b2 = new BigInteger("10032");
        BigInteger b3 = BigInteger.ONE;
        BigInteger b4 = BigInteger.valueOf(3224);

        // common operations
        System.out.println(b1.bitCount());
        System.out.println(b2.gcd(b4));
        System.out.println(b2.nextProbablePrime());

        System.out.println(bigFac(100));
    }
}
