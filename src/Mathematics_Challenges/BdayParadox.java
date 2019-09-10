package src.Introduction;

import java.util.Scanner;

public class BdayParadox {
    public static void main(String[] args) {
        double prob = new Scanner(System.in).nextDouble();
        double days = 365, num = 365;
        int n = 0;
        prob = 1 - prob;
        double prob1 = 1;
        while (prob1 > prob) {
            prob1 *= num / days;
            num--;
            n++;
        }
        System.out.println(n);
    }
}
