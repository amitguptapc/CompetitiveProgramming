// https://hack.codingblocks.com/practice/p/366/462

import java.util.Scanner;

public class UniqueNo1 {
    private static int unqNO(int[] a) {
        int res = 0;
        for (int i : a) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(unqNO(a));
    }
}