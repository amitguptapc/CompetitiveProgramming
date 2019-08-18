import java.util.Scanner;

public class NaiveAlgorithm {
    private static void findPattern(String str, String pat) {
        int n = str.length(), m = pat.length();
        boolean flag;
        for (int i = 0; i <= n - m; i++) {
            flag = true;
            for (int j = 0; j < m; j++) {
                if (str.charAt(i + j) != pat.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pat = sc.next();
        findPattern(str, pat);
    }
}
