import java.util.Scanner;

// can also be solved by formula
// catalan(n) = (2nCn)/(n+1)

public class CatalanNumbers {
    // DP approach O(n^2)
    private static int findCatalan(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;
        for (int i = 2; i <= n; i += 1) {
            for (int j = 1; j <= i; j++)
                catalan[i] += catalan[j - 1] * catalan[i - j];
        }
        return catalan[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findCatalan(n));
    }
}