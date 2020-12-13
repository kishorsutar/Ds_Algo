import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;


public class BinarySearchTree {

  static Node root;
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
           tree.root = new Node(1);
           tree.root.left = new Node(2);
           tree.root.right = new Node(3);
           tree.root.left.right = new Node(4);
           tree.root.left.right.right = new Node(5);
           tree.root.left.right.right.right = new Node(6);
           System.out.println("Following are nodes in top view of Binary tree");
           tree.TopView(tree.root);
  }

private static void TopView(Node node) {
  class QueueObj {
    Node node;
    int hd;

    QueueObj(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

// logic starts here

Queue<QueueObj> q = new LinkedList<QueueObj>();
Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

if(root == null) {
  return;
} else {
  q.add(new QueueObj(root, 0));
}

System.out.println("The top view of the tree is : ");

while(!q.isEmpty()) {
  QueueObj tempNode = q.poll();
  if(!topViewMap.containsKey(tempNode.hd)) {
    topViewMap.put(tempNode.hd, tempNode.node);
  }

  if(tempNode.node.left !=  null) {
    q.add(new QueueObj(tempNode.node.left, tempNode.hd - 1)); //
  }

  if(tempNode.node.right !=  null) {
    q.add(new QueueObj(tempNode.node.right, tempNode.hd + 1)); //
  }
}

for(Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
  System.out.println(entry.getValue().data);
}

}

static class Node {
  int data;
  Node left;
  Node right;

  Node (int value) {
    this.data = value;
    this.left = null;
    this.right = null;
  }
}
}
