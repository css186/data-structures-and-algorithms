package cse41321.Homework6;

public class Homework6 {

    // a) method to count the number of leaf nodes in binary tree
    public static int countLeaves(BinaryTree<Integer> tree) {
        return doCountLeaves(tree.getRoot());
    }
    // helper function to countLeaves
    private static int doCountLeaves(BinaryTree<Integer>.Node node) {
        if (node == null) return 0; // empty tree
        if (node.left == null && node.right == null) return 1;
        else return doCountLeaves(node.left) + doCountLeaves(node.right);
    }
    // b) method to count the number of non-leaf nodes in binary tree
    public static int countNonLeaves(BinaryTree<Integer> tree) {
        return doCountNonLeaves(tree.getRoot());
    }
    // helper function to countNonLeaves
    private static int doCountNonLeaves(BinaryTree<Integer>.Node node) {
        if (node == null || (node.left == null && node.right == null)) return 0; // empty tree
        else return 1 + doCountNonLeaves(node.left) + doCountNonLeaves(node.right);
    }
    // c) method to count the height of binary tree
    public static int getHeight(BinaryTree<Integer> tree) {
        return doGetHeight(tree.getRoot());
    }
    // helper function to getHeight
    private static int doGetHeight(BinaryTree<Integer>.Node node) {
        if (node == null) return -1; // height of empty tree is -1
        int leftHeight = doGetHeight(node.left);
        int rightHeight = doGetHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // d) method to print node pre-order
    public static void printPreOrder(BinaryTree<Integer> tree) {
        doPrintPreOrder(tree.getRoot());
    }
    // helper function to printPreOrder
    private static void doPrintPreOrder(BinaryTree<Integer>.Node node) {
        // base case
        if (node == null) return; // do nothing on empty tree
        System.out.print(node.data + "\t");
        doPrintPreOrder(node.left);
        doPrintPreOrder(node.right);
    }
    // e) method to print node in-order
    public static void printInOrder(BinaryTree<Integer> tree) {
        doPrintInOrder(tree.getRoot());
    }
    // helper function to printInOrder
    private static void doPrintInOrder(BinaryTree<Integer>.Node node) {
        if (node == null) return;
        doPrintInOrder(node.left);
        System.out.print(node.data + "\t");
        doPrintInOrder(node.right);
    }
    // f) method to print node post-order
    public static void printPostOrder(BinaryTree<Integer> tree) {
        doPrintPostOrder(tree.getRoot());
    }
    // helper function to printPostOrder
    private static void doPrintPostOrder(BinaryTree<Integer>.Node node) {
        if (node == null) return;
        doPrintPostOrder(node.left);
        doPrintPostOrder(node.right);
        System.out.print(node.data + "\t");
    }

    // g) method to remove leaves from binary tree
    public static void removeLeaves(BinaryTree<Integer> tree) {
        doRemoveLeaves(tree.getRoot(), null);
    }

    // helper function to removeLeaves
    private static void doRemoveLeaves(BinaryTree<Integer>.Node node, BinaryTree<Integer>.Node parent) {
        if (node == null) {
            return;
        }

        // Check if the current node is a leaf
        if (node.left == null && node.right == null) {
            // If the node is the root, set the root to null
            if (parent == null) {
                return;
            } else if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node) {
                parent.right = null;
            }
            return;
        }

        // Recurse for non-leaf nodes
        doRemoveLeaves(node.left, node);
        doRemoveLeaves(node.right, node);
    }

    public static void main(String[] args) {
        // Tree One
        BinaryTree<Integer> treeOne = new BinaryTree<>();
        treeOne.insertRoot(1);
        treeOne.getRoot().insertLeft(2);
        treeOne.getRoot().insertRight(3);
        treeOne.getRoot().getLeft().insertLeft(4);
        treeOne.getRoot().getLeft().getLeft().insertLeft(7);
        treeOne.getRoot().getRight().insertLeft(5);
        treeOne.getRoot().getRight().insertRight(6);
        treeOne.getRoot().getRight().getRight().insertRight(8);
        treeOne.getRoot().getRight().getRight().getRight().insertRight(9);

        System.out.println("Leaves of Tree One: " + countLeaves(treeOne));

        System.out.println("Non-leaves of Tree One: " + countNonLeaves(treeOne));

        System.out.println("Height of Tree One: " + getHeight(treeOne));

        System.out.println("Print Tree One Pre-Ordered: ");
        printPreOrder(treeOne);
        System.out.println();

        System.out.println("Print Tree One In-Ordered: ");
        printInOrder(treeOne);
        System.out.println();

        System.out.println("Print Tree One Post-Ordered: ");
        printPostOrder(treeOne);
        System.out.println();

        removeLeaves(treeOne);
        System.out.println("Print Tree One Pre-Ordered After Remove Leaves: ");
        printPreOrder(treeOne);
        System.out.println();

        System.out.println("Print Tree One In-Ordered After Remove Leaves: ");
        printInOrder(treeOne);
        System.out.println();

        System.out.println("Print Tree One Post-Ordered After Remove Leaves: ");
        printPostOrder(treeOne);
        System.out.println();

        System.out.println("==========");

        // Tree Two
        BinaryTree<Integer> treeTwo = new BinaryTree<>();
        treeTwo.insertRoot(6);
        treeTwo.getRoot().insertLeft(4);
        treeTwo.getRoot().insertRight(8);
        treeTwo.getRoot().getLeft().insertLeft(2);
        treeTwo.getRoot().getLeft().insertRight(5);
        treeTwo.getRoot().getLeft().getLeft().insertLeft(1);
        treeTwo.getRoot().getLeft().getLeft().insertRight(3);
        treeTwo.getRoot().getRight().insertLeft(7);
        treeTwo.getRoot().getRight().insertRight(9);

        System.out.println("Leaves of Tree Two: " + countLeaves(treeTwo));

        System.out.println("Non-leaves of Tree Two: " + countNonLeaves(treeTwo));

        System.out.println("Height of Tree Two: " + getHeight(treeTwo));

        System.out.println("Print Tree Two Pre-Ordered: ");
        printPreOrder(treeTwo);
        System.out.println();

        System.out.println("Print Tree Two In-Ordered: ");
        printInOrder(treeTwo);
        System.out.println();

        System.out.println("Print Tree Two Post-Ordered: ");
        printPostOrder(treeTwo);
        System.out.println();

        removeLeaves(treeTwo);
        System.out.println("Print Tree Two Pre-Ordered After Remove Leaves: ");
        printPreOrder(treeTwo);
        System.out.println();

        System.out.println("Print Tree Two In-Ordered After Remove Leaves: ");
        printInOrder(treeTwo);
        System.out.println();

        System.out.println("Print Tree Two Post-Ordered After Remove Leaves: ");
        printPostOrder(treeTwo);
        System.out.println();
    }

}
