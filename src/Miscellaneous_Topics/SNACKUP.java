import java.util.Scanner;

// Constructive Algorithm
// https://www.codechef.com/problems/SNACKUP

public class SNACKUP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                System.out.println(n);
                for (int j = 0; j < n; j++)
                    System.out.println(j + 1 + " " + ((i + j) % n + 1) + " " + ((i + j + 1) % n + 1));
            }
        }
    }
}