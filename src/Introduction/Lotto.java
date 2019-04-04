// Find all increasing sequences with length 6

public class Lotto {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int num = a.length;
        for (int i = 0; i < num - 5; i++) {
            for (int j = i + 1; j < num - 4; j++) {
                for (int k = j + 1; k < num - 3; k++) {
                    for (int l = k + 1; l < num - 2; l++) {
                        for (int m = l + 1; m < num - 1; m++) {
                            for (int n = m + 1; n < num; n++) {
                                System.out.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l] + " " + a[m] + " " + a[n]);
                            }
                        }
                    }
                }
            }
        }
    }
}
