import java.util.Scanner;

public class TilingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tiling(n));
    }

    private static int tiling(int n) {
        if (n < 4)
            return 1;
        return tiling(n - 1) + tiling(n - 4);
    }
}