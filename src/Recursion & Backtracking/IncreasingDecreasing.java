import java.util.Scanner;

public class IncreasingDecreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        increasing(n);
        System.out.println();
        decreasing(n);
    }

    private static void increasing(int n) {
        if (n == 0)
            return;
        increasing(n - 1);
        System.out.print(n + "\t");
    }

    private static void decreasing(int n) {
        if (n == 0)
            return;
        System.out.print(n + "\t");
        decreasing(n - 1);
    }
}