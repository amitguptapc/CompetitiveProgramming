package Bitmasking;

public class CountSetBits {

    // O(log N)
    private static int countSetBits1(int a) {
        int count = 0;
        while (a > 0) {
            count += a & 1;
            a >>= 1;
        }
        return count;
    }

    // Brian Kernighan's Algorithm
    // O(no of set bits in N)
    private static int countSetBits2(int a) {
        int count = 0;
        while (a > 0) {
            a &= a - 1;
            count++;
        }
        return count;
    }

    // O(no of set bits in N)
    private static int countSetBits3(int a) {
        int count = 0;
        while (a > 0) {
            a -= a & (-a);
            count++;
        }
        return count;
    }

    // Max num of bits in N is log(N).
    public static void main(String[] args) {
        System.out.println(countSetBits1(15));
        System.out.println(countSetBits2(15));
        System.out.println(countSetBits3(15));
        System.out.println(Integer.bitCount(15));
    }
}
