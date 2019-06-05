import java.util.Scanner;

public class LinearCongruence {
    private static long x, y;

    private static void mulModInv(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return;
        }
        mulModInv(b, a % b);
        long cx = y;
        long cy = x - (a / b) * y;
        x = cx;
        y = cy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long prod = 1;
        long[] num = new long[k];
        for (int i = 0; i < k; i++) {
            num[i] = sc.nextLong();
            prod *= num[i];
        }
        long[] rem = new long[k];
        for (int i = 0; i < k; i++)
            rem[i] = sc.nextLong();
        long[] pp = new long[k];
        for (int i = 0; i < k; i++)
            pp[i] = prod / num[i];
        long[] inv = new long[k];
        for (int i = 0; i < k; i++) {
            mulModInv(pp[i], num[i]);
            inv[i] = x;
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            res = (res + (((rem[i] * pp[i]) % prod) * inv[i]) % prod) % prod;
        }
        System.out.println((res + prod) % prod);
    }
}