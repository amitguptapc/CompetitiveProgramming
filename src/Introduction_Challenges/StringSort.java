// https://hack.codingblocks.com/contests/c/547/103

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StringSort implements Comparator<String> {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> s = new ArrayList<String>();
        while (n > 0) {
            s.add(sc.nextLine());
            n--;
        }
        s.sort(new StringSort());
        for (String i : s) {
            System.out.println(i);
        }
    }

    public int compare(String s, String t) {
        if (s.contains(t) || t.contains(s))
            return t.compareTo(s);
        else
            return s.compareTo(t);
    }
}