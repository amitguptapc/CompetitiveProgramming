package Recursion_N_Backtracking_Challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class CodesOfString {
    private static ArrayList<String> list;
    private static int n;
    private static String s;

    private static void getCodes(int i, String res) {
        if (i == n) {
            list.add(res);
            return;
        }

        // single digit consideration
        int m = Integer.parseInt(s.charAt(i) + "");
        String str = res + (char) (m + 96);
        getCodes(i + 1, str);

        // double digit consideration
        if (i < n - 1) {
            m = Integer.parseInt(s.substring(i, i + 2));
            if (m <= 26) {
                str = res + (char) (m + 96);
                getCodes(i + 2, str);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        n = s.length();
        list = new ArrayList<>();
        getCodes(0, "");
        System.out.println(list.toString());
    }
}