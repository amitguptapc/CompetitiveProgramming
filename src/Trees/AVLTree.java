public class AVLTree {
    Node root;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        tree.preOrder(tree.root);
    }

    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    Node leftRotate(Node n) {
        Node n1 = n.right;
        Node n2 = n1.left;
        n1.left = n;
        n.right = n2;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        n1.height = Math.max(height(n1.left), height(n1.right)) + 1;
        return n1;
    }

    Node rightRotate(Node n) {
        Node n1 = n.left;
        Node n2 = n1.right;
        n1.right = n;
        n.left = n2;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        n1.height = Math.max(height(n1.left), height(n1.right)) + 1;
        return n1;
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        // ll case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        // rr case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        // lr case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // rl case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private void preOrder(Node n) {
        if (n != null) {
            System.out.println(n.key);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    static class Node {
        int key, height;
        Node left, right;

        Node(int k) {
            key = k;
            height = 1;
            left = right = null;
        }
    }
}