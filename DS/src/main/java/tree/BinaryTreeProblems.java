package tree;

public class BinaryTreeProblems {

    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

    }

    private int height(BinaryTree root) {

        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
