import java.util.ArrayList;
import java.util.Scanner;

public class SumItUp {
    private static void sumUpto(ArrayList<Integer> a, int n, int t, String res) {
        if (t == 0) {
            System.out.println(res);
        }
        if (a.size() == 0)
            return;
        for (int i =0;i<a.size();i++) {
            res = res +a.get(i) + " ";
            ArrayList<Integer> b = a;
            b.remove(i);
            sumUpto(b, n, t - a.get(i), res);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++)
            a.add(sc.nextInt());
        int t = sc.nextInt();
        sumUpto(a, n, t, "");
    }
}