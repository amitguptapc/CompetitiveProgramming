import java.util.Scanner;

/**
 * Prints all the possible combination of strings that can be
 * obtained using all the digits of a given number
 */
public class PhoneKeypad {
    private static String[] keys = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

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

            /**
             * string is reference type in java, so we have to use a copy of pre
             * because any change in the value of pre in any one block
             * will change value of pre in all other recursive blocks
             * */

            String p = pre;
            p = p + ck.charAt(i);
            keypad(p, num.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        keypad("", s);
    }
}