import java.util.Scanner;

public class BostonNum {
    private static int factorSum(int n) {
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        if (n > 2)
            sum += n;
        return sum;
    }

    private static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (digitSum(n) == factorSum(n))
            System.out.println(1);
        else System.out.println(0);
    }
}