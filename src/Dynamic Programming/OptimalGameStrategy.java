import java.util.Scanner;

public class OptimalGameStrategy {
//    private static int winnerScore(int[] a, int n) {
//        int[][] dp=new int[n][n];
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
//        System.out.println(winnerScore(a, n));
    }
}