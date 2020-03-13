package ds;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeTraversal {
    public static void main(String[] args) {
        Node node = add('r');
        node.left = add('a');
        node.right = add('d');
        node.left.left = add('a');
        node.left.right = add('r');
//        node.left.right.right = add('r');


        System.out.println(isPalindrome(node));

    }

    static class Node {
        Node left, right = null;
        char data;
    };

    static Node add(char value) {
        Node node = new Node();
        node.data = value;
        node.left = null;
        node.right = null;
        return node;
    }


    // level order traversal

    static Stack<Node> levelOrderTraverse(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();

        if(root == null)
            return stack;

        q.add(root);

        while(!q.isEmpty()) {

            Node n = q.peek();
            stack.push(n);
            q.poll();
            System.out.println(n.data);

            if(n.left != null) {
                q.add(n.left);
            }

            if(n.right != null) {
                q.add(n.right);
            }
        }

        return stack;
    }

    static boolean isPalindrome(Node root) {
        Stack<Node> levelOrderStack = levelOrderTraverse(root);
        Queue<Node> q = new LinkedList<Node>();

        if(levelOrderStack.isEmpty()) {
            return false;
        }

        q.add(root);

        while(!q.isEmpty()) {
            Node n = q.peek();
            if(levelOrderStack.peek().data != n.data) {
                return false;
            }

            q.poll();
            levelOrderStack.pop();

            if(n.left != null) {
                q.add(n.left);
            }
            if(n.right != null) {
                q.add(n.right);
            }

        }

        return true;

    }

}

