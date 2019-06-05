import java.util.ArrayList;
import java.util.Scanner;

public class CodesOfString {
    private static ArrayList<String> list;

    private static void codes(String s, int i, String res) {
        if (i == s.length()) {
            list.add(res);
            return;
        }
        String str;
        int n = Integer.parseInt(s.charAt(i) + "");
        str = res;
        str = str + (char) (n + 96);
        codes(s, i + 1, str);
        if (i < s.length() - 1) {
            n = Integer.parseInt(s.substring(i, i + 2));
            if (n <= 26) {
                str = res;
                str = str + (char) (n + 96);
                codes(s, i + 2, str);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        list = new ArrayList<>();
        codes(s, 0, "");
        System.out.println(list.toString());
    }
}