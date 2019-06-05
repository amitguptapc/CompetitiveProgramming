import java.util.Scanner;

public class DiophantineEq {
    // solve equations of the form :
    // Ax + By = C where x nd y can take only integer values
    private static int x, y;

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

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int g = gcd(a, b);
        if (c % g == 0) {
            extendedEuclid(a, b);
            int k = c / g;
            x *= k;
            y *= k;
            System.out.println("Solution is : ( " + x + " + " + (b / g) + "t , " + y + " - " + (a / g) + "t )");
        } else System.out.println("Solution does not exist");
    }
}