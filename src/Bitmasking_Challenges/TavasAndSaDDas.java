package Bitmasking_Challenges;

// https://codeforces.com/problemset/problem/535/B

import java.util.Scanner;

public class TavasAndSaDDas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func1(n);
        func2(n);
    }

    // Method - 1
    private static void func1(int n) {
        int sum = 0;
        int d, i = 0;
        while (n > 0) {
            d = n % 10;
            if (d == 4)
                sum += 1 << i;
            else
                sum += 1 << (i + 1);
            i++;
            n /= 10;
        }
        System.out.println(sum);
    }

    // Method - 2
    private static void func2(int n) {
        String s = String.valueOf(n);
        int l = s.length();
        int ans = (1 << l) - 2;
        int cou = l - 1;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '7')
                ans += (1 << cou);
            cou--;
        }
        System.out.println(ans + 1);
    }
}