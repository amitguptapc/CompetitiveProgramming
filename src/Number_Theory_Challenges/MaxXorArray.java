import java.util.Scanner;

public class MaxXorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long xor = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            xor ^= a[i];
        }
        long mXor = xor;
        for (int i = 0; i < n; i++) {
            if ((xor ^ a[i]) > xor)
                mXor = xor ^ a[i];
        }
        if (xor > mXor)
            System.out.println(xor);
        else System.out.println(mXor);
    }
}