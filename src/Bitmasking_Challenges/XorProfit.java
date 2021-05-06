import java.util.Scanner;

public class XorProfit {
    private static long maxXor(long x, long y) {
        long xor = x ^ y;
        long pos = 0;
        while (xor > 0) {
            pos++;
            xor = xor >> 1;
        }
        return (1L << pos) - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        System.out.println(maxXor(x, y));
    }
}