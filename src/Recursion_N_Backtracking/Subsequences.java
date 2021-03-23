import java.util.Scanner;

public class Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        subsequence("", s);
    }

    private static void subsequence(String pre, String s) {
        if (s.length() == 0) {
            System.out.println(pre + s);
            return;
        }
        subsequence(pre + s.charAt(0), s.substring(1)); // including a character
        subsequence(pre, s.substring(1)); // excluding a character
    }
}