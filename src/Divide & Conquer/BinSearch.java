public class BinSearch {
    private static int binarySearch(int[] a, int n, int num) {
        int s = 0, e = n - 1, mid;
        while (s <= e) {
            mid = (s + e) / 2;
            if (a[mid] == num)
                return mid;
            if (a[mid] < num)
                s = mid + 1;
            if (a[mid] > num)
                e = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 8, 9, 10, 35, 100, 110};
        System.out.println(binarySearch(a, 9, 10));
    }
}