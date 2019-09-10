import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MikeHashTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], 0);
        }
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (map.get(a[i]) == 0) {
                b.add(0, a[i]);
                map.put(a[i], 1);
            }
        }
        for (int i : b)
            System.out.println(i);
    }
}
