package Bitmasking_Challenges;

// https://hack.codingblocks.com/contests/c/366/135

import java.util.Scanner;

public class IncredibleHulk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }
            System.out.println(count);
            t--;
        }
    }
}