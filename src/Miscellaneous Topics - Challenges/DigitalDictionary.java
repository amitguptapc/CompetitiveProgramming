import java.util.Scanner;
import java.util.TreeMap;

public class DigitalDictionary {
    static class Trie {
        static class TrieNode {
            char data;
            boolean isTerminal;
            TreeMap<Character, TrieNode> map;

            public TrieNode(char c) {
                data = c;
                map = new TreeMap<>();
                isTerminal = false;
            }
        }

        private TrieNode root;

        private Trie() {
            root = new TrieNode('\0');
        }

        private void addWord(String word) {
            TrieNode temp = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (temp.map.get(ch) == null) {
                    TrieNode child = new TrieNode(ch);
                    temp.map.put(ch, child);
                    temp = child;
                } else temp = temp.map.get(ch);
            }
            temp.isTerminal = true;
        }

        private void suggestions(String word) {
            TrieNode temp = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (temp.map.get(ch) != null)
                    temp = temp.map.get(ch);
                else {
                    this.addWord(word);
                    System.out.println("No suggestions");
                    return;
                }
            }
            printAllSuggestions(temp, word, word);
        }

        private static void printAllSuggestions(TrieNode temp, String word, String sug) {
            if (temp.map.size() == 0) {// end of word
                System.out.println(sug);
                sug = word;
            } else if (temp.isTerminal)
                System.out.println(sug);
            for (char c : temp.map.keySet()) {
                printAllSuggestions(temp.map.get(c), word, sug + c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie t = new Trie();
        while (n-- > 0)
            t.addWord(sc.next());
        int q = sc.nextInt();
        String s;
        while (q-- > 0) {
            s = sc.next();
            t.suggestions(s);
        }
    }
}