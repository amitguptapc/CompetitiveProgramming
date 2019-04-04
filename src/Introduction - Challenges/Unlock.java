import java.util.Scanner;

public class Unlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] pl = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            pl[a[i]] = i;
        }
        for (int i = 0; i < n && k != 0; i++) {
            if (a[i] != n - i) {
                int temp = a[i];
                a[i] = n - i;
                a[pl[n - i]] = temp;
                pl[temp] = pl[n - i];
                pl[n - i] = i;
                k--;
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}