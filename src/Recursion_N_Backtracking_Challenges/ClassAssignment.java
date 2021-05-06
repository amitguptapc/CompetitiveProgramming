import java.util.Scanner;

public class ClassAssignment {
    // similar to fibonacci series
    private static long noOfWays(int n, char prev) {
        if (n == 1) {
            if (prev == 'a')
                return 2;
            else return 1;
        }
        if (prev == 'a')
            return noOfWays(n - 1, 'a') + noOfWays(n - 1, 'b');
        else return noOfWays(n - 1, 'a');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println("#" + i++ + " : " + noOfWays(n, 'a'));
        }
    }
}