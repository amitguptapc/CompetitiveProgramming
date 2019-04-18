import java.util.HashMap;

public class Trie {
    static class TrieNode {
        char data;
        boolean isTerminal;
        HashMap<Character, TrieNode> map;

        public TrieNode(char c) {
            data = c;
            map = new HashMap<>();
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

    private boolean isPresent(String word) {
        TrieNode temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (temp.map.get(ch) != null)
                temp = temp.map.get(ch);
            else return false;
        }
        return temp.isTerminal;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "ape", "pen", "pencil", "mango"};
        Trie tree = new Trie();
        for (String word : words) tree.addWord(word);
        System.out.println(tree.isPresent("man"));
        System.out.println(tree.isPresent("pen"));
        System.out.println(tree.isPresent("app"));
        System.out.println(tree.isPresent("pencil"));
    }
}