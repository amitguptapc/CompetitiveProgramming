import java.util.Scanner;

public class ModularExpo {
    private static long moduloExpo(long a, long b, long c) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                ans = (ans * a) % c;
            a = (a * a) % c;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a, b, c;
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        System.out.println(moduloExpo(a, b, c));
    }
}