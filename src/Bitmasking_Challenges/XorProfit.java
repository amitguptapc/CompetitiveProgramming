import java.util.Scanner;

public class XorProfit {
    private static int maxXor(int x, int y) {
        int xor = x ^ y;
        int pos = 0;
        while (xor > 0) {
            pos++;
            xor = xor >> 1;
        }
        return (2 << pos - 1) - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(maxXor(x, y));
    }
}