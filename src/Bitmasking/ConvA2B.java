package src.Bitmasking;

import java.util.Scanner;

// No of bits that must be changed to convert a to b

public class ConvA2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a ^ b;
        System.out.println(countSetBits(c));
    }

    // 1. find bits which vary using XOR
    // 2. count the set bits in XOR
    private static int countSetBits(int a) {
        int count = 0;
        while (a > 0) {
            count++;
            a &= a - 1;
        }
        return count;
    }
}