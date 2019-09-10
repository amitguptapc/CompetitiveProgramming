import java.util.Scanner;

public class PowerLogN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(calculatePower(n, p));
    }

    private static int calculatePower(int n, int p) {
        if (p == 0)
            return 1;
        int m = calculatePower(n, p / 2);
        if (p % 2 == 0)
            return m * m;
        else
            return n * m * m;
    }
}