package tree;

import graph.AdjacencyList;

import java.util.ArrayList;
import java.util.List;

public class TreeProblems {

    class TreeNode {
        TreeNode parent;
        int value;
        List<TreeNode> children;

        TreeNode(int val, TreeNode parent) {
            this.value = val;
            children = new ArrayList<>();
            this.parent = parent;
        }

        public void addChildren(TreeNode node) {
            children.add(node);
        }

    }

    // Sum of leaf nodes
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

    // Rooting a tree
    private TreeNode rootingATree(AdjacencyList graph, int rootValue) {
        TreeNode root = new TreeNode(rootValue, null);
        return buildTree(graph, root, null);
    }

    private TreeNode buildTree(AdjacencyList graph, TreeNode root, TreeNode parent) {

        for (AdjacencyList.Edge edge : graph.getNeighbours(root.value)) {
            if (parent != null && edge.dst == root.value)
                continue;

            TreeNode childNode = new TreeNode(edge.dst, root);
            root.children.add(childNode);
            buildTree(graph, childNode, root);
        }

        return root;
    }
}