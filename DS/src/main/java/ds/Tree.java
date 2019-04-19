
// class TreeNode<E> {
// 	int height;
// 	TreeNode<E> parent;
// 	List<TreeNode<E>> childrens;

// }


// class BinaryTree {
//     Node root;
    
//     int maxDepth(Node node) {
//     	if(node == null) {
//     		return 0;
//     	} else {

//     		int lDepth = maxDepth(node.left);
//     		int rDepth =maxDepth(node.right);

//     		if(lDepth > rDepth) {
//     			return (lDepth + 1);
//     		} else {
//     			return (rDepth + 1);
//     		}
//     	}

//     }

//     public static void main(String[] args) {
//     	BinaryTree tree = new BinaryTree();
//     	tree.root = new Node(1);
//     	tree.root.left = new Node(2); 
//         tree.root.right = new Node(3); 
//         tree.root.left.left = new Node(4); 
//         tree.root.left.right = new Node(5); 
   
//         System.out.println("Height of tree is : " +  
//                                       tree.maxDepth(tree.root)); 
//     }

// }
import java.util.*;

class TreeNode<T> {
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
    private T data = null;
	
	public TreeNode(T data){
        this.data = data;
    }       

    public List<TreeNode<T>> getChildren(){
        return children;
    }   

    public void setChild(TreeNode<T> children){
        this.children.add(children);
    }   
	public int getTreeHeight(TreeNode<T> root) {
		int height = 0;
		if(root == null) {
			return height;
		}

		if(root.children == null) {
			return 1;
		}

		for(TreeNode<Integer> child : root.children) {
			height = Math.max(height, getTreeHeight(child));
		}

		return height + 1;
	}

	 public static void main(String[] args) {
    	TreeNode<Integer> root = new TreeNode<Integer>(50);
	    TreeNode<Integer> c1 = new TreeNode<Integer>(100);
	    TreeNode<Integer> c2= new TreeNode<Integer>(10);
	    TreeNode<Integer> c3 = new TreeNode<Integer>(-5);
	    TreeNode<Integer> c4 = new TreeNode<Integer>(0);
	    TreeNode<Integer> c5 = new TreeNode<Integer>(33);
	    TreeNode<Integer> c6 = new TreeNode<Integer>(1);
	    TreeNode<Integer> c7 = new TreeNode<Integer>(2);
	    TreeNode<Integer> c8 = new TreeNode<Integer>(3);
	    TreeNode<Integer> c9 = new TreeNode<Integer>(300);
	    TreeNode<Integer> c10 = new TreeNode<Integer>(350);

	    root.setChild(c1);
	    root.setChild(c2);
	    c2.setChild(c3);
	    c3.setChild(c4);
	    c3.setChild(c5);
	    c3.setChild(c6);
	    c3.setChild(c7);
	    c3.setChild(c8);

	    c1.setChild(c9);
	    c1.setChild(c10);

System.out.println();
    System.out.print("\nHeigth: \n");
    System.out.println(root.getHeight(root));
    }
}