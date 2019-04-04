import java.util.Scanner;

public class PlayWithBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            for (int i = a; i <= b; i++) {
                int j = i;
                while (j > 0) {
                    j &= (j - 1);
                    count++;
                }
            }
            System.out.println(count);
            q--;
        }
    }
}