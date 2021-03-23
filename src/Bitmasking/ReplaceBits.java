package Bitmasking;

// Replace bits in N by M
public class ReplaceBits {
    private static int replaceBits(int n, int m, int i, int j) {
        int mask = (-1 << (j + 1)) | ((1 << i) - 1);
        n = n & mask; // clear the bits from in to j
        m = m << i;
        return n | m;
    }

    public static void main(String[] args) {
        System.out.println(replaceBits(15, 2, 1, 3));
    }
}
