package Bitmasking;

public class Decimal2Binary {
    private static String dec2bin(int n) {
        String bin = "";
        while (n > 0) {
            int last = n & 1;
            bin = last + bin;
            n >>= 1;
        }
        return bin;
    }

    public static void main(String[] args) {
        System.out.println(dec2bin(108));
    }
}
