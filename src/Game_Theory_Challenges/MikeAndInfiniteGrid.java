import java.io.*;
import java.util.StringTokenizer;

// https://www.codechef.com/AUG11/problems/IGAME
public class MikeAndInfiniteGrid {
    private static int max = 1000;
    private static int[][] grid = new int[max + 1][max + 1];

    private static void fillGrid() {
        for (int i = 0; i <= max; i++)
            for (int j = 0; j <= max; j++)
                if (grid[i][j] == 0) {
                    grid[i][j] = 2;
                    for (int k = i + 1; k <= max; k++)
                        grid[k][j] = 1;
                    for (int k = j + 1; k <= max; k++)
                        grid[i][k] = 1;
                    for (int k = 1; k + i <= max && k + j <= max; k++)
                        grid[k + i][k + j] = 1;
                }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        fillGrid();
        int t = Integer.parseInt(br.readLine()), a, b, c, d;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            bw.write(grid[a - c][b - d] == 1 ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
}