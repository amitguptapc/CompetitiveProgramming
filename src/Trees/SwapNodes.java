import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */ static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node reverse(Node root, int value, int level) {
        if (root == null)
            return root;
        if ((level + 1) % value == 0) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        root.left = reverse(root.left, value, level + 1);
        root.right = reverse(root.right, value, level + 1);
        return root;
    }

    static void findTraversal(Node root) {
        if (root == null)
            return;
        findTraversal(root.left);
        path[idx++] = root.data;
        findTraversal(root.right);
    }

    static int[] path;
    static int idx;

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Node head = new Node(1);
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        int i = 0, m = 1;
        while (q.size() != 0) {
            Node temp = q.poll();
            if (indexes[i][0] != -1) {
                m++;
                temp.left = new Node(indexes[i][0]);
                q.add(temp.left);
            }
            if (indexes[i][1] != -1) {
                m++;
                temp.right = new Node(indexes[i][1]);
                q.add(temp.right);
            }
            i++;
        }
        int n = queries.length;
        int[][] tra = new int[n][m];
        for (int j = 0; j < n; j++) {
            path = new int[m];
            idx = 0;
            head = reverse(head, queries[j], 0);
            findTraversal(head);
            tra[j] = path;
        }
        return tra;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println();
            }
        }
    }
}
