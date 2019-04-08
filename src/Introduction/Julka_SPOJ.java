package src.Introduction;

// https://www.spoj.com/problems/JULKA/

import java.math.BigInteger;
import java.util.Scanner;

public class Julka_SPOJ {
    public static void main(String[] args) {
        int t = 10;
        BigInteger b1, b2;
        Scanner sc = new Scanner(System.in);
        while (t > 0) {
            b1 = sc.nextBigInteger();
            b2 = sc.nextBigInteger();
            BigInteger x = b1.subtract(b2);
            x = x.divide(BigInteger.valueOf(2));
            BigInteger y = x.add(b2);
            System.out.println(y + " " + x);
            t--;
        }
    }
}
