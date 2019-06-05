import java.util.*;

public class SumItUp {
    private static TreeSet<String> set;

    private static void sumUpto(int[] a, int i, int n, int t, ArrayList<Integer> list) {
        if (t == 0) {
            Collections.sort(list);
            set.add(list.toString().replace(",", "").substring(1).replace("]", ""));
            return;
        }
        if (i >= n)
            return;
        if (a[i] <= t) {
            ArrayList<Integer> ar = new ArrayList<>(list);
            ar.add(a[i]);
            sumUpto(a, i + 1, n, t - a[i], ar);
        }
        sumUpto(a, i + 1, n, t, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int t = sc.nextInt();
        set = new TreeSet<>();
        sumUpto(a, 0, n, t, new ArrayList<>());
        for (String i : set)
            System.out.println(i);
    }
}