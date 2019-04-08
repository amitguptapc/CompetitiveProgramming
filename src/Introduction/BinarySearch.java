package src.Introduction;

public class BinarySearch {
    private static int binSearch1(int a[], int k) {
        int low = 0, high = a.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (k == a[mid])
                return mid;
            if (a[mid] > k)
                high = mid - 1;
            if (a[mid] < k)
                low = mid + 1;
        }
        return -1;
    }

    private static int binSearch2(int a[], int k, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == k)
                return mid;
            if (a[mid] > k)
                return binSearch2(a, k, low, mid - 1);
            if (a[mid] < k)
                return binSearch2(a, k, mid + 1, high);
        }
        return -1;
    }

    private static int lowerBound(int a[], int k) {
        int low = 0, high = a.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (k <= a[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private static int upperBound(int a[], int k) {
        int low = 0, high = a.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (k >= a[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 3, 3, 5, 6, 8};
        System.out.println(lowerBound(a, 3));
        System.out.println(upperBound(a, 3));
    }
}
