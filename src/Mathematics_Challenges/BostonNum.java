import java.util.Scanner;

public class BostonNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        if (digitSum(num) == primeFactors(num))
            System.out.println(1);
        else System.out.println(0);
    }

    private static long digitSum(long num) {
        long s2 = 0;
        while (num > 0) {
            s2 += num % 10;
            num /= 10;
        }
        return s2;
    }

    private static long primeFactors(long n) {
        long sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        long m = (long) Math.sqrt(n);
        for (long i = 3; i <= m; i += 2) {
            while (n % i == 0) {
                sum += digitSum(i);
                n /= i;
            }
        }
        if (n > 2)
            sum += digitSum(n);
        return sum;
    }
}