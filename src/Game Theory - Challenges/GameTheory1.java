import java.util.Scanner;

public class GameTheory1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 1)
                System.out.println(2);
            else {
                if ((n & 1) == 0)
                    System.out.println(2);
                else System.out.println(1);
            }
        }
    }
}