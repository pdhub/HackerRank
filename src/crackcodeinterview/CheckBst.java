package crackcodeinterview;

public class CheckBst {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data > maxValue || root.data < minValue)
            return false;
        return isBST(root.left, minValue, root.data - 1)
                && isBST(root.right, root.data + 1, maxValue);
    }
}
