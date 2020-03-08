package ds;

import java.util.*;

public class QueueExample {

    public void exQueue() {
        Queue<String> tes = new LinkedList<>();
        Queue<String> pQueue = new PriorityQueue<>();
        pQueue.isEmpty();
//pQueue.get
        pQueue.poll();

        pQueue.clear();

        ArrayList<Integer> t = new ArrayList<>();

        Queue<Integer> intQueue = new PriorityQueue<>();

//      t.a
    }

    class BinaryTreeNode {
        BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;
    }

    void levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        BinaryTreeNode temp;
        Queue queue = new PriorityQueue();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            System.out.println(temp);
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }

        }

        queue.clear();
    }

}
