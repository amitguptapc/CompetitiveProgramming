import java.util.Scanner;

// Complexity O(log b)

public class FastExpo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(fastExponent(a, b));
    }

    private static int fastExponent(int a, int b) {
        if (b == 0)
            return 1;
        int n = fastExponent(a, b / 2);
        n *= n;
        if ((b & 1) == 1)
            n *= a;
        return n;
    }
}