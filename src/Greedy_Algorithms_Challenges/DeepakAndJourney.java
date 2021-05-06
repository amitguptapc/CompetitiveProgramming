import java.util.Scanner;

public class DeepakAndJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] c = new long[n];
            long[] l = new long[n];
            for (int i = 0; i < n; i++)
                c[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                l[i] = sc.nextLong();
            long pre = c[0];
            long cost = pre * l[0];
            for (int i = 1; i < n; i++) {
                if (c[i] < pre)
                    pre = c[i];
                cost += pre * l[i];
            }
            System.out.println(cost);
        }
    }
}