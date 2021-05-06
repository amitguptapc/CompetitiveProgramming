import java.text.DecimalFormat;
import java.util.Scanner;

public class Chicago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0)
                return;
            int m = sc.nextInt();
            double[][] path = new double[n][n];
            int u, v;
            double p;
            for (int i = 0; i < m; i++) {
                u = sc.nextInt() - 1;
                v = sc.nextInt() - 1;
                p = sc.nextDouble() / 100;
                path[u][v] = path[v][u] = p;
            }
            for (int k = 0; k < n; k++) // Floyd Warshall
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        path[i][j] = Math.max(path[i][j], path[i][k] * path[k][j]);
            System.out.println(new DecimalFormat("#0.000000").format(path[0][n - 1] * 100) + " percent");
        }
    }
}