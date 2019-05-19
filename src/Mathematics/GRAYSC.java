package src.Mathematics;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.codechef.com/problems/GRAYSC

public class GRAYSC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // if n>=130 this means that there will be at least 65 pairs
        // so at least one bit will be set for more than 1 number for 64 bit
        if (n >= 130) {
            System.out.println("Yes");
        } else {
            BigInteger[] a = new BigInteger[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextBigInteger();
            for (int i = 0; i < n - 3; i++)
                for (int j = i + 1; j < n - 2; j++)
                    for (int k = j + 1; k < n - 1; k++)
                        for (int l = k + 1; l < n; l++)
                            if ((a[i].xor(a[j]).xor(a[k]).xor(a[l])).equals(BigInteger.ZERO)) {
                                System.out.println("Yes");
                                return;
                            }
            System.out.println("No");
        }
    }
}