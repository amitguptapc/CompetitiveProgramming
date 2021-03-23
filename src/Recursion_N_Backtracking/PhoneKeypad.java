import java.util.Scanner;

/**
 * Prints all the possible combination of strings that can be
 * obtained using all the digits of a given number
 */
public class PhoneKeypad {
    private static final String[] keys = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static void keypad(String pre, String num) {
        if (num.length() == 0) {
            System.out.println(pre);
            return;
        }
        String ck = keys[Integer.parseInt(num.charAt(0) + "")];
        if (ck.equals("")) {
            keypad(pre, num.substring(1));
            return;
        }
        for (int i = 0; i < ck.length(); i++) {
            keypad(pre + ck.charAt(i), num.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        keypad("", s);
    }
}