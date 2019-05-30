import java.util.Scanner;

public class ExtendedEuclid {
    private static int x;
    private static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        extendedEuclid(a, b);
        System.out.println("X : " + x + "\nY : " + y);
    }

    // Solve equation of the form
    // AX + BY = GCD(A,B)
    private static void extendedEuclid(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        extendedEuclid(b, a % b);
        int cx = y;
        int cy = x - (a / b) * y;
        x = cx;
        y = cy;
    }
}