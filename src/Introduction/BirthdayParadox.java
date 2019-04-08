package src.Introduction;

import java.util.Scanner;

//Find no of people required in a room such that probability of 2 person having same birthday is 'prob'

public class BirthdayParadox {
    public static void main(String[] args) {
        System.out.println("Enter probability :");
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
        System.out.println("No of people required to have " + prob + " probability of 2 people having same birthday : " + n);
    }
}
