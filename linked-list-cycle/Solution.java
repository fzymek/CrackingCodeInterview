public class Solution {

	static class Node {
		int data;
		Node next;

		Node(int x) { 
			this.data = x; 
			this.next = null;
		}

	}

	public boolean hasCycle(Node node) {
		return false;
	}

	public static void main(String []args) {

		Node head = null;
		
		System.out.println(new Solution().hasCycle(head));
	}



}
