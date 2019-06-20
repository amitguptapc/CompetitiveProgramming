import java.util.Arrays;
import java.util.Scanner;

// Ref book
// connect white balls with black balls such that minimum length of wires is used.
// given that the balls are equally spaced
// coordinates of the white and black balls are given in a 1 dimension.

public class ConnectingWires {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n]; // coordinates of white balls
        int[] b = new int[n]; // coordinates of black balls
        for (int i = 0; i < n; i++)
            w[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        Arrays.sort(w);
        Arrays.sort(b);
        int wireReq = 0;
        for (int i = 0; i < n; i++)
            wireReq += Math.abs(b[i] - w[i]);
        System.out.println(wireReq);
    }
}