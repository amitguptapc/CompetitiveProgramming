// pre-requisite for GSS1
// Kadane's Algorithm is used to find largest sum subarray in a given array
public class Kadane {
    private static int kadane(int[] a, int n) {
        int maxSoFar = 0, maxEndingHere = 0;
        for (int i = 0; i < n; i++) {
            maxEndingHere += a[i];
            if (maxEndingHere < 0)
                maxEndingHere = 0;
            else if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = 8;
        System.out.println(kadane(a, n));
    }
}