package src.Bitmasking;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        if ((a & 1) == 1)
            System.out.println("Odd");
        else
            System.out.println("Even");
    }
}