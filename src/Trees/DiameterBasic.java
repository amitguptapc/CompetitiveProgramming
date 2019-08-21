package Trees;

public class DiameterBasic {
    private static int findHeight(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    // Complexity O(n*h)
    private static int findDiameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int x = findHeight(root.left) + findHeight(root.right);
        int y = findDiameter(root.left);
        int z = findDiameter(root.right);
        return Math.max(x, Math.max(y, z));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.addLeft(2);
        root.addRight(3);
        root.left.addLeft(4);
        root.left.left.addLeft(5);
        root.left.left.left.addLeft(5);
        root.left.addRight(7);
        root.left.right.addRight(8);
        root.left.right.right.addRight(9);
        root.left.right.right.right.addRight(10);
        root.left.right.right.right.right.addRight(11);
        System.out.println(findDiameter(root));
    }
}