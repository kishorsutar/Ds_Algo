package algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class ZigZagTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean addFirst = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> interResult = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(addFirst)
                    interResult.addFirst(node.val);
                else
                    interResult.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            addFirst = !addFirst;
            result.add(interResult);
        }
        return result;
    }


    class TreeNode {
        private final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
