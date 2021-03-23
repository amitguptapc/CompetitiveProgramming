import java.util.Scanner;

public class SmartKeypad1 {
    private static final String[] keys = {" ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static void printKeys(String pre, String s) {
        if (s.length() == 0) {
            System.out.println(pre);
            return;
        }
        String st = keys[Integer.parseInt(s.charAt(0) + "")];
        for (int i = 0; i < st.length(); i++) {
            printKeys(pre + st.charAt(i), s.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printKeys("", s);
    }
}