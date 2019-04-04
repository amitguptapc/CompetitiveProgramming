public class Pivot {
    private static void findPivot(int[] a, int n) {
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid > start && a[mid] < a[mid - 1]) {
                System.out.println(mid - 1);
                break;
            }
            if (mid < end && a[mid] > a[mid + 1]) {
                System.out.println(mid);
                break;
            }
            if (a[start] >= a[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (start > end)
            System.out.println("Pivot not present");
    }

    // index of largest element in a rotated sorted array
    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 11, 12, 13, 14, 5, 6};
        findPivot(a, 10);
    }
}