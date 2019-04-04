import java.util.Scanner;

public class N2048 {
    private static String[] spellings = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);
    }

    private static void solve(int n) {
        if (n == 0)
            return;
        solve(n / 10);
        System.out.print(spellings[n % 10] + " ");
    }
}