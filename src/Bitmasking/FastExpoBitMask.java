package Bitmasking;

public class FastExpoBitMask {
    private static int expo(int a, int b) {
        int ans = 1;
        while (b > 0) {
            int lbit = b & 1;
            if (lbit == 1)
                ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(expo(2, 10));
    }
}
