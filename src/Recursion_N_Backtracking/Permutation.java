package Backtracking;

import java.util.Scanner;

public class Permutation {
    private static void permute(StringBuilder s, int j) {
        if (j == s.length()) {
            System.out.println(s);
            return;
        }
        for (int i = j; i < s.length(); i++) {
            swap(s, i, j);
            permute(s, j + 1);
            // backtracking to restore the original string
            swap(s, i, j);
        }
    }

    private static void swap(StringBuilder s, int i, int j) {
        char c1 = s.charAt(j);
        char c2 = s.charAt(i);
        s.setCharAt(j, c2);
        s.setCharAt(i, c1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        permute(new StringBuilder(s), 0);
    }
}
