package Trees;

public class BinaryTreeNode<T> {
    public BinaryTreeNode<T> left, right;
    private T value;

    BinaryTreeNode(T val) {
        this.value = val;
        left = null;
        right = null;
    }

    void addLeft(T val) {
        this.left = new BinaryTreeNode<>(val);
    }

    void addRight(T val) {
        this.right = new BinaryTreeNode<>(val);
    }
}