import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Set<Integer> res=new HashSet<>();
        int j = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && !res.contains(a[j]))
                res.add(a[j++]);
            ans += (j - i) * (j - i + 1) / 2;
            res.remove(a[i]);
        }
        System.out.println(ans);
    }
}