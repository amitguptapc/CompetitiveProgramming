package Trees;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 11/09/19
 * Time : 2:28 AM
 * Problem Code : LCA
 * Platform : NA
 */

public class LCA {
    static class Node {
        int data;
        Node left, right;

        Node(int n) {
            data = n;
            left = right = null;
        }

        void addLeft(int n) {
            left = new Node(n);
        }

        void addRight(int n) {
            right = new Node(n);
        }
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.addLeft(2);
        root.addRight(3);
        root.left.addLeft(4);
        root.left.left.addLeft(5);
        root.left.left.left.addLeft(6);
        root.left.addRight(7);
        root.left.right.addRight(8);
        root.left.right.right.addRight(9);
        root.left.right.right.right.addRight(10);
        root.left.right.right.right.right.addRight(11);
        System.out.println(lca(root, 6, 8).data);
        System.out.println(lca(root, 6, 5).data);
    }
}