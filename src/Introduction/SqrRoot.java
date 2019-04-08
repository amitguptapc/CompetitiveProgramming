package src.Introduction;

// Find square root of a number using Binary Search

import java.util.Scanner;

public class SqrRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        int n = sc.nextInt();
        System.out.println("Enter precision :");
        int p = sc.nextInt();
        double sq = sqr(n);
        double placeVal = 0.1;
        double val = sq;
        while (p > 0) {
            for (int i = 9; i >= 0; i--) {
                val = sq + i * placeVal;
                if (val * val <= n) {
                    sq = val;
                    break;
                }
            }
            placeVal /= 10;
            p--;
        }
        System.out.println(val);
    }

    private static int sqr(int n) {
        int low = 1, high = n, mid;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid == n) {
                ans = mid;
                break;
            }
            if (mid * mid > n)
                high = mid - 1;
            if (mid * mid < n) {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
