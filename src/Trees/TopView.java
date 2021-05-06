package Trees;

import java.util.TreeMap;

/**
 * Author : AMIT KUMAR GUPTA
 * e-mail : amitguptapc@gmail.com
 * Date : 10/09/19
 * Time : 6:53 PM
 * Problem Code : TopView
 * Platform : NA
 */

public class TopView {
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

    static class Pair {
        int node;
        int distance;

        Pair(int p, int d) {
            node = p;
            distance = d;
        }
    }

    private static void fillMap(Node root, int vd, int hd, TreeMap<Integer, Pair> map) {
        if (root == null)
            return;
        if (!map.containsKey(vd))
            map.put(vd, new Pair(root.data, hd));
        else if (map.get(vd).distance > hd)
            map.put(vd, new Pair(root.data, hd));
        fillMap(root.left, vd - 1, hd + 1, map);
        fillMap(root.right, vd + 1, hd + 1, map);
    }

    private static void topView(Node root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        fillMap(root, 0, 0, map);
        for (int i : map.keySet())
            System.out.println(map.get(i).node);
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
        topView(root);
    }
}