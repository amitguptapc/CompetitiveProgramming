import java.util.Scanner;

public class CROSSWORD {
    private static boolean wordMatch(char[][] grid, String word, int i, int j, int l, int cl, int n) {
        if (cl == l)
            return true;
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;
        if (grid[i][j] == word.charAt(cl))
            return (wordMatch(grid, word, i, j + 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i + 1, j + 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i - 1, j + 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i, j - 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i + 1, j - 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i - 1, j - 1, l, cl + 1, n) ||
                    wordMatch(grid, word, i + 1, j, l, cl + 1, n) ||
                    wordMatch(grid, word, i - 1, j, l, cl + 1, n));
        return false;
    }

    private static boolean wordFound(char[][] grid, String word, int l, int n) {
        if (l > n * n)
            return false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == word.charAt(0) && wordMatch(grid, word, i, j, l, 0, n))
                    return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] word = new String[n];
        for (int i = 0; i < n; i++)
            word[i] = sc.next();
        int m = sc.nextInt();
        char[][] grid = new char[m][m];
        for (int i = 0; i < m; i++)
            grid[i] = sc.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if (wordFound(grid, word[i], word[i].length(), m))
                System.out.print(word[i] + " ");
        }
        System.out.println();
    }
}