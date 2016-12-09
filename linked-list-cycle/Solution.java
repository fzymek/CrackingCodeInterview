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

		if (node == null) return false;		

		Node slow, fast;
		slow = node;
		fast = slow.next;

		while (slow != fast) {
			
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				return false;
			}

			if (slow.next != null) {
				slow = slow.next;
			} else {
				return false;
			}
		
		}


		return true;
	}

	public static void print(Node n) { 
		int maxNodes = 120;
		int i = 0;
		StringBuffer s = new StringBuffer();
		while (n != null) {
			if (i++ > maxNodes) {
				break;
			}
			s.append(n.data).append("->");
			n = n.next;
		}
		
		s.append(" X ");
		System.out.println(s.toString());
	}

	public static void main(String []args) {

		Node noCycleHead = createList();	
		Node cycleHead = createListWithCycle();	
		
		print(noCycleHead);
		System.out.println();
		print(cycleHead);
		
		System.out.println(new Solution().hasCycle(noCycleHead));
		System.out.println(new Solution().hasCycle(cycleHead));
	}

	public static Node createList() {
		Node listHead = new Node(0);
		Node current = listHead;
		for(int i = 1; i < 60; i++) {
			current.next = new Node(i);
			current = current.next;
		}

		return listHead;
	}

	public static Node createListWithCycle() {

		int cycleNodeData = 55;
		Node head = createList();
		
		Node current = head;
		Node cycleNode= null;
		
		while (current.next != null) {
			if (current.data == cycleNodeData) {
				cycleNode = current;
			} 
			current = current.next;	
		}
		current.next = cycleNode;
		return head;
	}

}
