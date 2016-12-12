public class Solution {


	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	
	}

	public static void main(String []args) {
		Node root = constructTree(true);
		
		System.out.println(new Solution().checkBST(root));
	}	


	boolean checkBST(Node node) {
		return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isValidBST(Node node, int currentMin, int currentMax) {
		if (node == null) return true;

		//System.out.print(node.data + " -> ");
		
		if (node.data <= currentMin || node.data >= currentMax) {
			return false;
		}
		
		return isValidBST(node.left, currentMin, node.data) &&  isValidBST(node.right, node.data, currentMax);
	}
	

	/**
		Constructs following tree:	

			  50
		       /      \
		    17	        72
		  /   \      /     \
	       12      23  54      76
              /  \     /     \     / 
 	     9   14   19      67 (70*)
		
	*/
	static Node constructTree(boolean isValid) {
		
		Node root = new Node(50);
		root.left = new Node(17);
		root.left.left = new Node(12);
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(14);
		root.left.right = new Node(23);
		root.left.right.left = new Node(19);

		root.right = new Node(72);
		root.right.left = new Node(54);
		root.right.right = new Node(67);
		root.right.right = new Node(76);
		
		if (!isValid) {
			//this makes bst invalid
			root.right.right.left = new Node(70);
		}
		
		return root;

	}
}
