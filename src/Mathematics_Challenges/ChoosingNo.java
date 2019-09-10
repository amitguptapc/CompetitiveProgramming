import java.text.DecimalFormat;
import java.util.Scanner;

public class ChoosingNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        double n = sc.nextDouble();
        System.out.println(df.format(n * 9.0 / 100.0));
    }
}