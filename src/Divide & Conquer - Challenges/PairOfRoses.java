import java.util.Arrays;
import java.util.Scanner;

public class PairOfRoses {
    private static int x, y;

    private static void findSolution(int[] a, int n,int m) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int m=sc.nextInt();
            Arrays.sort(a);
            findSolution(a, n,m);
            System.out.println("Deepak should buy roses whose prices are " + x + " and " + y + ".");
        }
    }
}