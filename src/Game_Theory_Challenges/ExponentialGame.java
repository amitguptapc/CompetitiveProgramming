import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

// https://www.codechef.com/LTIME05/problems/EXPGAME
public class ExponentialGame {
    private static int[] expo = {1, 4, 27, 256, 3125, 46656};
    private static int max = 100000;
    private static int[] nimber = new int[max + 1];

    private static int getMex(TreeSet<Integer> set) {
        int c = 0;
        while (set.contains(c))
            c++;
        return c;
    }

    private static void getGrundy() {
        for (int i = 1; i <= max; i++) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int k = 0; k < 6; k++) {
                if (expo[k] <= i)
                    set.add(nimber[i - expo[k]]);
            }
            nimber[i] = getMex(set);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        getGrundy();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int ans = 0, a;
            for (int i = 0; i < n; i++) {
                a = Integer.parseInt(st.nextToken());
                ans ^= nimber[a];
            }
            if (ans == 0)
                bw.write("Head Chef\n");
            else bw.write("Little Chef\n");
        }
        bw.flush();
    }
}