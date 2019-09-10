import java.util.Scanner;

public class BinaryString {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        while (t-- > 0) {
            res = 0;
            n = sc.nextInt();
            generateStrings("", n);
            System.out.println(res);
        }
    }

    private static void generateStrings(String s, int n) {
        int m = s.length();
        if (m == n) {
            res++;
            return;
        }
        generateStrings(s + "0", n);
        if (m == 0 || s.charAt(m - 1) != '1')
            generateStrings(s + "1", n);
    }
}