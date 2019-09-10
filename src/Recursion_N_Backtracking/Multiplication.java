import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(multiply(a, b));
    }

    private static int multiply(int a, int b) {
        if (Math.abs(b) > Math.abs(a))
            return multiply(b, a);
        if (b == 0)
            return 0;
        if (b > 0)
            return a + multiply(a, b - 1);
        else
            return -a + multiply(a, b + 1);
    }
}