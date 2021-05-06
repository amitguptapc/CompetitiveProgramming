import java.util.Scanner;

public class FindIt {
    private static long[] pre;

    private static void divisors(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                pre[i]++;
                if (i != Math.sqrt(n))
                    pre[n / i]++;
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pre = new long[100001];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            divisors(sc.nextInt());
        int q = sc.nextInt();
        while (q-- > 0)
            System.out.println(pre[sc.nextInt()]);
    }
}