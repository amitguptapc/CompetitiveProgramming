import java.util.HashSet;
import java.util.Scanner;

public class BeautifulVertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int u, v;
        int[][] adj = new int[m][2];
        for (int i = 0; i < m; i++) {
            u = sc.nextInt() - 1;
            v = sc.nextInt() - 1;
            adj[i][0] = u;
            adj[i][1] = v;
            a[u]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (a[adj[i][1]] > a[adj[i][0]])
                set.add(adj[i][1]);
        }
        System.out.println(set.size());
    }
}