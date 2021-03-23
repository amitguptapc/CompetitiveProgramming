package Bitmasking;

public class BasicOp {
    private static void xorSwap() {
        int a = 56, b = 98;
        System.out.println(a + " " + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + " " + b);
    }

    private static int getIthBit(int a, int i) {
        return (a & (1 << i)) > 0 ? 1 : 0;
    }

    private static int setIthBit(int a, int i) {
        return a | (1 << i);
    }

    private static int resetIthBit(int a, int i) {
        return a & (~(1 << i));
    }

    // set ith bit to v
    private static int updateIthBit(int a, int i, int v) {
        a = a & (~(1 << i)); // clear the ith bit
        a = a | (v << i); // set the ith bit with v
        return a;
    }

    private static int clearLastIbits(int a, int i) {
        int mask = (-1 << i);
        return a & mask;
    }

    private static int clearRangeOfBits(int a, int i, int j) {
        int mask = (-1 << (j + 1)) | ((1 << i) - 1);
        return a & mask;
    }

    public static void main(String[] args) {
        xorSwap();
        System.out.println(getIthBit(16, 2));
        System.out.println(setIthBit(13, 1));
        System.out.println(resetIthBit(15, 1));
        System.out.println(updateIthBit(5, 3, 1));
        System.out.println(~0); // ~0 is equal to -1
        System.out.println(clearLastIbits(15, 2));
        System.out.println(clearRangeOfBits(31, 1, 3));
    }
}