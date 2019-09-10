import java.util.Scanner;

public class GCDnLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int gcd = GCD(n, m);
        int lcm = (n * m) / gcd;
        System.out.println("GCD : " + gcd);
        System.out.println("LCM : " + lcm);
    }

    // Euclid's Algorithm
    // Time Complexity O(log max(a,b))
    private static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}