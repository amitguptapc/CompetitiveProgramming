package src.Bitmasking;

// print all sub sequences of a given string.

import java.util.Scanner;

public class SubseqOfStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        generateSubseq(s);
    }

    private static void generateSubseq(String s) {
        int n = s.length();
        n = (1 << n) - 1;
        for (int i = 0; i <= n; i++) {
            printSubseq(s, i);
        }
    }

    private static void printSubseq(String s, int n) {
        String res = "";
        int i = 0;
        while (n > 0) {
            res += (n & 1) == 1 ? s.charAt(i) : "";
            n >>= 1;
            i++;
        }
        System.out.println(res);
    }
}