import java.util.Scanner;

public class StringToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        System.out.println(strToInt(s, n));
    }

    private static int strToInt(String s, int n) {
        if (n == 0)
            return 0;
        int val = s.charAt(n - 1) - '0';
        return val + (strToInt(s, n - 1) * 10);
    }
}