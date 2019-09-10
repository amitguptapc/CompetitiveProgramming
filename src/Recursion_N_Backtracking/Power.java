public class Power {
    public static void main(String[] args) {
        System.out.println(fastPower(2, 20));
        System.out.println(power(2, 20));
    }

    private static int power(int a, int b) {
        if (b == 0)
            return 1;
        return a * power(a, b - 1);
    }

    private static int fastPower(int a, int b) {
        if (b == 0)
            return 1;
        int sp = fastPower(a, b / 2);
        sp *= sp;
        if ((b & 1) == 1)
            sp *= a;
        return sp;
    }
}