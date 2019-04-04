import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(squareRoot(n, p));
    }

    private static float squareRoot(int n, int p) {
        int s = 0, e = n, mid;
        float res = 0;

        // calculating the integer part
        while (s <= e) {
            mid = (s + e) / 2;
            if (mid * mid == n) {
                res = mid;
                break;
            }
            if (mid * mid < n) {
                s = mid + 1;
                res = mid;
            } else
                e = mid - 1;
        }

        // calculating the fractional part
        float inc = 0.1f;
        for (int i = 0; i < p; i++) {
            while (res * res <= n) {
                res += inc;
            }
            res = res - inc;
            inc /= 10;
        }
        String ans = Float.toString(res);
        ans = ans.substring(0, ans.indexOf('.') + p+1);
        res=Float.parseFloat(ans);
        return res;
    }
}