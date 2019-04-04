import java.util.Scanner;

public class UltraFastMath{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String s,r;
        while(t>0){
            s=sc.next();
            r=sc.next();
//            System.out.println(r+" "+s);
            int n=s.length();
            String res="";
            for(int i=0;i<n;i++){
                if(s.charAt(i)==r.charAt(i))
                    res=res+"0";
                else
                    res=res+"1";
            }
            System.out.println(res);
            t--;
        }
    }
}