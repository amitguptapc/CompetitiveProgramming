public class RotatedArraySearch {
    private static int search(int[] a, int s, int e, int key) {
        if (s > e)
            return -1;
        int mid = (s + e) / 2;
        if (a[mid] == key)
            return mid;
        if (a[s] <= a[mid]) {
            if (key <= a[mid] && key >= a[s])
                return search(a, s, mid - 1, key);
            else
                return search(a, mid + 1, e, key);
        }
        if (key >= a[mid] && key <= a[e])
            return search(a, mid + 1, e, key);
        return search(a, s, mid - 1, key);
    }

    public static void main(String[] args) {
        int[] a = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
        System.out.println(search(a, 0, 9, 3));
    }
}