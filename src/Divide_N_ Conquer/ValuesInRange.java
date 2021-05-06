// Find starting and ending index for subarray which lies in the given range
public class ValuesInRange {
    private static int upperBound(int[] a, int k) {
        int s = 0, e = a.length - 1, m, idx = -1;
        while (s <= e) {
            m = (s + e) / 2;
            if (a[m] <= k) {
                idx = m;
                s = m + 1;
            } else
                e = m - 1;
        }
        return idx;
    }

    private static int lowerBound(int[] a, int k) {
        int s = 0, e = a.length - 1, m, idx = -1;
        while (s <= e) {
            m = (s + e) / 2;
            if (a[m] >= k) {
                idx = m;
                e = m - 1;
            } else
                s = m + 1;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 5, 6, 9, 9, 9, 12, 14, 20, 40, 50, 65, 100, 10045};
        int start = 4;
        int end = 90;
        System.out.println(lowerBound(a, start) + " " + upperBound(a, end));
    }
}