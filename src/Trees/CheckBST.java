package Trees;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 11/09/19
 * Time : 5:23 PM
 * Problem Code : CheckBST
 * Platform : NA
 */

public class CheckBST {
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

    private static boolean checkBST(Node root, int l, int r) {
        if (root == null)
            return true;
        if (root.data > l && root.data < r) {
            return checkBST(root.left, l, root.data) &&
                    checkBST(root.right, root.data, r);
        }
        return false;

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.addLeft(5);
        root.addRight(15);
        root.left.addLeft(2);
        root.left.addRight(8);
        root.right.addLeft(12);
        root.right.addRight(17);
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}