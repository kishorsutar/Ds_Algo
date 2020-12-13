package tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeafNodes {

    // input input array?

    // output int sum of all leaf node

    //

    class TreeNode {
        int value;
        List<TreeNode> children;

        TreeNode(int val) {
            this.value = val;
            children = new ArrayList<>();
        }

        public void addChildren(TreeNode node) {
            children.add(node);
        }
    }

    private int sumOfLeafs(TreeNode node) {
        int sum = 0;

        // if node.children.size() == 0 or null
        // add to sum
        // else root =

        if (node == null)
            return sum;

        if (isLeafNode(node))
            return node.value;

        for (TreeNode child : node.children) {
            sum += sumOfLeafs(child);
        }
        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.children.size() == 0;
    }
}