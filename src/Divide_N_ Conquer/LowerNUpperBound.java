public class LowerNUpperBound {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 2, 7, 8, 9, 10, 35, 100, 110};
        System.out.println(lowerBound(a, 2, 12));
        System.out.println(upperBound(a, 2, 12));
    }

    private static int lowerBound(int[] a, int num, int n) {
        int s = 0, e = n - 1, mid, ans = -1;
        while (s <= e) {
            mid = (s + e) / 2;
            if (a[mid] == num) {
                e = mid - 1;
                ans = mid;
            } else if (a[mid] < num)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return ans;
    }

    private static int upperBound(int[] a, int num, int n) {
        int s = 0, e = n - 1, mid, ans = -1;
        while (s <= e) {
            mid = (s + e) / 2;
            if (a[mid] == num) {
                s = mid + 1;
                ans = mid;
            } else if (a[mid] < num)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return ans;
    }
}