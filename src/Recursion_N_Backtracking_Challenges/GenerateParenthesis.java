import java.util.Scanner;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateParens("", n, 0, 0);
    }

    private static void generateParens(String res, int n, int open, int close) {
        if (close == n) {
            System.out.println(res);
        } else {
            if (open > close)
                generateParens(res + ")", n, open, close + 1);
            if (open < n)
                generateParens(res + "(", n, open + 1, close);
        }

    }
}