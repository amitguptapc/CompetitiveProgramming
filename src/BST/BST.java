package BST;

public class BST {
    static class Node {
        int key;
        Node left, right;

        Node(int d) {
            key = d;
            left = right = null;
        }
    }

    private Node head;

    private BST() {
        head = null;
    }

    private Node _addKey(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = _addKey(root.left, key);
        else if (key > root.key)
            root.right = _addKey(root.right, key);
        return root;
    }

    private void addKey(int key) {
        head = _addKey(head, key);
    }

    private void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }

    private boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key > root.key)
            return search(root.right, key);
        return search(root.left, key);
    }

    private Node _deleteKey(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = _deleteKey(root.left, key);
        else if (key > root.key)
            root.right = _deleteKey(root.right, key);
            // if  node to be deleted has one child or no child
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // if node to be deleted has 2 children
            root.key = inorderSuccessor(root.right);
            root.right = _deleteKey(root.right, root.key);
        }
        return root;
    }

    private int inorderSuccessor(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    private void deleteKey(int key) {
        head = _deleteKey(head, key);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.addKey(50);
        tree.addKey(30);
        tree.addKey(20);
        tree.addKey(40);
        tree.addKey(70);
        tree.addKey(60);
        tree.addKey(80);
        tree.inorder(tree.head);
        System.out.println(tree.search(tree.head, 40));
        tree.deleteKey(50);
        tree.deleteKey(60);
        tree.inorder(tree.head);
    }
}