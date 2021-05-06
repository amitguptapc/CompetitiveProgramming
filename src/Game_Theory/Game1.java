import java.util.Scanner;

public class Game1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // no of coins
        int n = sc.nextInt();
        // A plays first, both A and B can pick 1 or 2 coins
        if (n % 3 == 0)
            System.out.println("B");
        else
            System.out.println("A");
    }
}