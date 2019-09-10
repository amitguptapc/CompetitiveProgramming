import java.util.Scanner;
import java.util.TreeSet;

public class DictionaryOrder {
    private static StringBuilder st;
    private static TreeSet<String> str;

    private static void permute(StringBuilder s, int j) {
        if (j == s.length()) {
            if (s.toString().compareTo(st.toString()) > 0)
                str.add(s.toString());
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
        StringBuilder s = new StringBuilder(sc.nextLine());
        st = new StringBuilder(s);
        str = new TreeSet<>();
        permute(s, 0);
        for (String i : str)
            System.out.println(i);
    }
}