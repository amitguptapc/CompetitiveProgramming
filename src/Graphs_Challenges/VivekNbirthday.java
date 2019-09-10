import java.util.ArrayList;
import java.util.Scanner;

public class VivekNbirthday {
    private static int n, d;
    private static ArrayList<Integer>[] dependency;
    private static boolean[] visited;

    private static int dfs(int n) {
        visited[n] = true;
        int m = 1;
        for (int neighbour : dependency[n]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                m += dfs(neighbour);
            }
        }
        return m;
    }

    private static int findMinFriends() {
        visited = new boolean[n];
        int min = dfs(0);
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                min = Math.min(min, dfs(i));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        dependency = new ArrayList[n];
        for (int i = 0; i < n; i++)
            dependency[i] = new ArrayList<>();
        for (int i = 0; i < d; i++)
            dependency[sc.nextInt() - 1].add(sc.nextInt() - 1);
        System.out.println(findMinFriends());
    }
}