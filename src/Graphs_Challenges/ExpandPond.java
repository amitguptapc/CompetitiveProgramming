import java.util.HashSet;
import java.util.Scanner;

public class ExpandPond {
    static boolean[][] visited;
    static int[][] pond;
    static int n, m, len = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] component; // to store which vertex belongs to which component
    static int[] size; // to store size of component

    static void dfs(int x, int y, int color) {
        visited[x][y] = true;
        component[x][y] = color;
        int nx, ny;
        len++;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && pond[nx][ny] == 1)
                dfs(nx, ny, color);
        }
        size[color] = len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pond = new int[n][m];
        component = new int[n][m];
        visited = new boolean[n][m];
        size = new int[n * m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                pond[i][j] = sc.nextInt();

        // dfs to find all components and their sizes
        int color = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pond[i][j] == 1 && !visited[i][j]) {
                    len = 0;
                    dfs(i, j, color++);
                }

        int max = 0, x, y;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pond[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        x = i + dx[k];
                        y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m)
                            set.add(size[component[x][y]]);
                    }
                    int sum = 1;
                    for (int a : set)
                        sum += a;
                    max = Math.max(sum, max);
                }
        System.out.println(max);
    }
}