import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StationBalance {
    static DecimalFormat df = new DecimalFormat("0.00000");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int no = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        ArrayList<Integer> a = new ArrayList<>();
        int x;
        double avg = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * c; i++) {
            if (i < s) {
                x = Integer.parseInt(st.nextToken());
                avg += x;
                a.add(x);
            } else
                a.add(0);
        }
        avg /= c;
        double diff = 0;
        Collections.sort(a);
        int i = 0, j = 2 * c - 1;
        int v = 0;
        System.out.println("Set #" + no++);
        while (i <= j) {
            int cc = a.get(i++);
            int dd = a.get(j--);
            diff += Math.abs(cc + dd - avg);
            System.out.print(v++ + ": ");
            if (cc != 0)
                System.out.print(cc + " ");
            System.out.println(dd + " ");
        }
        System.out.println("IMBALANCE = " + df.format(diff));
    }
}