import java.util.Scanner;

public class SmartKeypadAdvanced {
    private static final String[] searchIn = {"prateek", "sneha", "deepak", "arnav", "shikha", "palak",
            "utkarsh", "divyam", "vidhi", "sparsh", "akku"};
    private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static void findNames(String pre, String s) {
        if (s.length() == 0) {
            for (int i = 0; i < 11; i++)
                if (searchIn[i].contains(pre))
                    System.out.println(searchIn[i]);
            return;
        }
        String st = keys[Integer.parseInt(s.charAt(0) + "")];
        for (int i = 0; i < st.length(); i++) {
            findNames(pre + st.charAt(i), s.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        findNames("", s);
    }
}