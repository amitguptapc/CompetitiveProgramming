import java.util.Scanner;

public class PilesAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int s = sc.nextInt();
            int[] a = new int[s];
            int ans = 0;
            for (int i = 0; i < s; i++) {
                a[i] = sc.nextInt();
                if ((a[i] & 1) == 1)
                    ans ^= i;
            }
            System.out.println(ans == 0 ? "Second" : "First");
        }
    }
}