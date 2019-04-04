// https://www.spoj.com/problems/ACMCEG2B/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Figureful_SPOJ {
    public static void main(String[] args) throws IOException {
        HashMap<ArrayList<Integer>, String> table = new HashMap<ArrayList<Integer>, String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            String s = br.readLine();
            String a[] = s.trim().split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(Integer.parseInt(a[0]));
            arr.add(Integer.parseInt(a[1]));
            table.put(arr, a[2]);
            n--;
        }
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            String a[] = s.trim().split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(Integer.parseInt(a[0]));
            arr.add(Integer.parseInt(a[1]));
            System.out.println(table.get(arr));
            t--;
        }
    }
}
