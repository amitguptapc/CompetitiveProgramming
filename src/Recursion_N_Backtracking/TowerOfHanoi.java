import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TOH(n, 'A', 'B', 'C');
    }

    // Move N disks from source peg to destination peg using auxiliary peg
    private static void TOH(int n, char source, char auxiliary, char destination) {
        if (n == 0)
            return;
        TOH(n - 1, source, destination, auxiliary); // Move n-1 disks from source to auxiliary using destination
        System.out.println("Move " + n + " th disk from peg " + source + " to peg " + destination); // Move nth disk from source to destination
        TOH(n - 1, auxiliary, source, destination); // Move n-1 disks from auxiliary to destination using source
    }
}