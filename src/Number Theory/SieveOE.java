import java.util.Scanner;

// Sieve Of Eratosthenes
// Complexity O(N log(log(N)))

public class SieveOE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println("No");
            return;
        }
        int[] num = sieve(n);
        System.out.println("Prime No(s) are :");
        for (int i = 2; i <= n; i++)
            if (num[i] == 1)
                System.out.print(i + "  ");
    }

    private static int[] sieve(int n) {
        int[] num = new int[n + 1];
        num[2] = 1;
        for (int i = 3; i <= n; i += 2)
            num[i] = 1;
        for (int i = 3; i * i <= n; i += 2) {
            if (num[i] == 1) {
                for (int j = i * i; j <= n; j += 2 * i)
                    num[j] = 0;
            }
        }
        return num;
    }
}