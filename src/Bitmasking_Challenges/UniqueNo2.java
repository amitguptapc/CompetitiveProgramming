// https://hack.codingblocks.com/practice/p/366/463

import java.util.Scanner;

public class UniqueNo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            x ^= a[i];
        }
        findUniq2(a, n, x);
    }

    private static void findUniq2(int[] a, int n, int x) {
        int y = x;
        int pos = 0;
        while (y > 0) {
            if ((y & 1) == 1)
                break;
            pos++;
            y >>= 1;
        }
        int firstNo = 0;
        int mask = 1 << pos;
        for (int i = 0; i < n; i++) {
            firstNo ^= (a[i] & mask) > 0 ? a[i] : 0;
        }
        int secondNo = firstNo ^ x;
        System.out.println(firstNo < secondNo ? (firstNo + " " + secondNo) : (secondNo + " " + firstNo));
    }
}