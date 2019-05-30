import java.util.ArrayList;
import java.util.Scanner;

public class DeepakNPrimes {
    private static ArrayList<Integer> sieve(int n) {
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
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (num[i] == 1)
                list.add(i);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sieve(5000000).get(n - 1));
    }
}