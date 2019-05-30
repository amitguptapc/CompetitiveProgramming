import java.math.BigInteger;
import java.util.Scanner;

public class ViratNFact{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger ans=BigInteger.ONE;
        for (int i=2;i<=n;i++)
            ans=ans.multiply(BigInteger.valueOf(i));
        System.out.println(ans);
    }
}