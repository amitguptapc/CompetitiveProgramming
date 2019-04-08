package src.Introduction;

import java.util.Scanner;

public class BigFactorial {
    private static void fact(int num) {
        int a[] = new int[1000];
        int pos = 1;
        a[0] = 1;
        for (int i = 2; i <= num; i++)
            pos = multiply(a, pos, i);
        for (int i = pos - 1; i >= 0; i--)
            System.out.print(a[i]);
    }

    private static int multiply(int a[], int pos, int n) {
        int carry = 0;
        for (int i = 0; i < pos; i++) {
            int prod = (a[i] * n) + carry;
            a[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry > 0) {
            a[pos] = carry % 10;
            carry /= 10;
            pos++;
        }
        return pos;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        fact(n);
    }
}
