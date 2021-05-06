import java.util.Scanner;

public class AreTheySame {
    private static boolean isSame(String a, String b) {
        if (a.equals(b))
            return true;
        int n1 = a.length(), n2 = b.length();
        if (n1 != n2 || (n1 & 1) == 1 || (n2 & 1) == 1)
            return false;
        String a1 = a.substring(0, n1 / 2);
        String a2 = a.substring(n1 / 2);
        String b1 = b.substring(0, n2 / 2);
        String b2 = b.substring(n2 / 2);
        return (isSame(a1, b1) && isSame(a2, b2)) || (isSame(a1, b2) && isSame(a2, b1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(isSame(a, b) ? "YES" : "NO");
        }
    }
}