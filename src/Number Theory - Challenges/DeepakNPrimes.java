import java.util.Scanner;

public class DeepakNPrimes {
    private static int nn;

    private static void sieve(int n) {
        boolean[] num = new boolean[n + 1];
        num[2] = true;
        for (int i = 3; i <= n; i += 2)
            num[i] = true;
        for (int i = 3; i * i <= n; i += 2) {
            if (num[i]) {
                for (int j = i * i; j <= n; j += 2 * i)
                    num[j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (num[i])
                count++;
            if (count == nn) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nn = sc.nextInt();
        // 5000000th prime number is 86028121
        sieve(86028121);
    }
}