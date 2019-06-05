import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenNOddDivisors {
    private static long divisor(int n) {
        long ans = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if ((i & 1) == 1)
                    ans -= i;
                else ans += i;
                if (i * i != n) {
                    if (((n / i) & 1) == 1)
                        ans -= n / i;
                    else ans += n / i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] div = new long[100001];
        for (int i = 0; i <= 100000; i++)
            div[i] = divisor(i);
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(div[n]);
        }
    }
}