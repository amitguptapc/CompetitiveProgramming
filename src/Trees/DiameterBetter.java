package Trees;

public class DiameterBetter {
    private static Pair<Integer, Integer> findHeightDiameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new Pair<>(0, 0);
        Pair<Integer, Integer> left = findHeightDiameter(root.left);
        Pair<Integer, Integer> right = findHeightDiameter(root.right);
        int hei = 1 + Math.max(left.height, right.height);
        int x = left.height + right.height;
        int y = left.diameter;
        int z = right.diameter;
        int dia = Math.max(x, Math.max(y, z));
        return new Pair<>(hei, dia);
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
        System.out.println(findHeightDiameter(root).diameter);
    }

    public static class Pair<T, V> {
        T height;
        V diameter;

        Pair(T first, V second) {
            this.height = first;
            this.diameter = second;
        }
    }
}