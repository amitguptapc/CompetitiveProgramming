import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String pattern = br.readLine();
        System.out.println(findWindow(s, pattern));
    }

    private static String findWindow(String str, String pat) {
        int n1 = str.length();
        int n2 = pat.length();
        if (n1 < n2)
            return "No";
        int[] hashStr = new int[256];
        int[] hashPat = new int[256];
        for (int i = 0; i < n2; i++)
            hashPat[pat.charAt(i)]++;
        int count = 0, start = 0, startInd = -1, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n1; i++) {
            hashStr[str.charAt(i)]++;
            if (hashPat[str.charAt(i)] != 0 && hashStr[str.charAt(i)] <= hashPat[str.charAt(i)])
                count++;
            if (count == n2) {
                while (hashStr[str.charAt(start)] > hashPat[str.charAt(start)] || hashPat[str.charAt(start)] == 0) {
                    if (hashStr[str.charAt(start)] > hashPat[str.charAt(start)])
                        hashStr[str.charAt(start)]--;
                    start++;
                }
                int window = i - start + 1;
                if (window<minLen) {
                    minLen = window;
                    startInd = start;
                }
            }
        }
        if (startInd == -1)
            return "No";
        return str.substring(startInd, startInd + minLen);
    }
}