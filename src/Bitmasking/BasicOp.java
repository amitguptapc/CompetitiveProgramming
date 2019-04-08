package src.Bitmasking;
public class BasicOp {

    // O(log N)
    private static int countSetBits1(int a) {
        int count = 0;
        while (a > 0) {
            count++;
            a &= a - 1;
        }
        return count;
    }

    // O(N)
    private static int countSetBits2(int a) {
        int count = 0;
        while (a > 0) {
            count += a & 1;
            a = a >> 1;
        }
        return count;
    }

    private static int countSetBits3(int a) {
        int count = 0;
        while (a > 0) {
            a = a - (a & (-a));
            count++;
        }
        return count;
    }

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

    public static void main(String[] args) {
        System.out.println(countSetBits1(15));
        System.out.println(countSetBits2(15));
        xorSwap();
        System.out.println(getIthBit(16, 2));
        System.out.println(setIthBit(13, 1));
        System.out.println(resetIthBit(15, 1));
    }
}