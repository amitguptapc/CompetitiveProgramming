import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TOH(n, 'A', 'B', 'C');
    }

    // Move N disks from source peg to destination peg using auxillary peg
    private static void TOH(int n, char source, char auxillary, char destination) {
        if (n == 0)
            return;
        TOH(n - 1, source, destination, auxillary);
        System.out.println("Move " + n + " th disk from peg " + source + " to peg " + destination);
        TOH(n - 1, auxillary, source, destination);
    }
}