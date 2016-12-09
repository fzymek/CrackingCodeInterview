public class Solution {

	static class Node {
		int data;
		Node next;

		Node(int x) { 
			this.data = x; 
			this.next = null;
		}

	}

	public boolea hasCycle(Node node) {
		return false;
	}

	public static void main(String args...) {

		System.out.println(new Solution().hasCycle(head));
	}



}
