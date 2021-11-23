import java.util.Vector;

class BinarySearchTree {
	 public static class Node {

	        public String data;
	        public Node left;
	        public Node right;


	        public Node(String data) {
	            this.data = data;
	            this.left = null;
	            this.right = null;
	        }
	    }

	    public Node root;

	    public BinarySearchTree() {
	        this.root = null;
	    }

	    public void insert(String newData) {
	        this.root = insert(root, newData);
	    }

	    public Node insert(Node root, String newData) {

	        if (root == null) {

	            root = new Node(newData);

	            return root;
	        }
	        
	        else if ( newData.compareTo(root.data)<0) {
	        	
	            root.left = insert(root.left, newData);
	        } else {

	            root.right = insert(root.right, newData);
	        }
	        return root;
	    }  
	    public void preorder(){
	        preorder(root);
	        System.out.println();
	    }
	    public void preorder(Node node){
	        if(node!=null){
	            System.out.print(node.data+" ");
	            preorder(node.left);
	            preorder(node.right);
	        }
	    }
	    boolean Search(String data,Node root) {
	        root=search(root,data);
	        if(root!=null)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
	    }

	    Node search(Node root, String data) {
	        if (root == null|| data.compareTo(root.data)==0) {
	            return root;
	        } 
	        int check=data.compareTo(root.data);
	        if(check<0)
	        {
	        	return search(root.left,data);
	        }
	        return search(root.right,data);
	    }
	    public void inOrder() {
	        inOrder(root);
	      }

	      private void inOrder(Node node) {
	        if (node == null) {
	          return;
	        }

	        inOrder(node.left);
	        System.out.print(node.data+"\n");
	        inOrder(node.right);
	      }
	 /*
	    public static void main(String[] args) {
	        BinarySearchTree bst = new BinarySearchTree();
	        bst.insert("hello");
	        bst.insert("maybe");
	        bst.insert("this");
	        bst.insert("i");
	        bst.insert("issue");   
	       
	       if(bst.Search("i"))
	       {
	    	   System.out.print("dunno whats wrong");
	       }
	        bst.inOrder();
	  
	    }
	 */
	
}

