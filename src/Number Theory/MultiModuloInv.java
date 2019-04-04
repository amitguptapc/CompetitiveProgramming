import java.util.Scanner;

public class MultiModuloInv {
    private static int x, y, gcd;

    private static int euclidGCD(int a, int b) {
        if (b == 0)
            return a;
        return euclidGCD(b, a % b);
    }

    private static void extendedEuclid(int a, int b) {
        if (b == 0) {
            gcd = a;
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

    // To calculate Multiplicative Modulo Inverse of A wrt M
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        if (euclidGCD(a, m) != 1)
            System.out.println("Multiplication Modulo Inverse No Possible");
        else {
            extendedEuclid(a, m);
            x = (x + m) % m;
            System.out.println("Multiplicative Modulo Inverse : " + x);
        }
    }
}