import java.util.HashMap;
import java.util.TreeMap;

/**
 * 1. HashMap works on hash function :
 * - O(1) for insertion, deletion, searching.
 * - Unordered.
 * 2. TreeMap works with RB Tree :
 * - O(log N) for insertion, deletion, searching.
 * - Ordered.
 */

public class HashingDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> fruit = new HashMap<>();
        fruit.put("Mango", 100);
        fruit.put("Apple", 20);
        if (fruit.containsKey("Mango"))
            System.out.println(fruit.get("Mango"));
        TreeMap<String, Integer> car = new TreeMap<>();
    }
}
