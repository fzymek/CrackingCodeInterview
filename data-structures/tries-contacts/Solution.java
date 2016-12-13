import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static class Trie {

		Node root;

		Trie() {
			root = new Node('\0');
		}

		void add(String data) {
			if (data == null || data.length() == 0) return;
			char []letters = data.toCharArray();
			Node current = root;
			for(char c : letters) {
				if (!current.hasChild(c)) {
					current.addChild(new Node(c));	
				}
				current.count++;
				current = current.getChild(c);
			}
			current.count++; //full word is also a word

		}

		int find(String text) {
			if (text == null || text.length() == 0) {
				return -1;
			}
			
			char []letters = text.toCharArray();
			Node current = root;

			for(char c: letters) {
				if (current.hasChild(c)) {
					current = current.getChild(c);
				} else {
					return 0;	
				}	

			}			


			return current.count;
		}

		public String toString() {
			return root.toString();
		}
	
	}

	static class Node {
		char c;
		int count;
		Map<Character, Node> childs;

		Node(char c) {
			this.c = c;
			childs = new HashMap<>();
			count = 0;
		}

		boolean hasChild(char c) {
			return this.childs.containsKey(c);
		}
		
		Node getChild(char c) {
			return this.childs.get(c);
		}

		void addChild(Node n) {
			this.childs.put(n.c, n);
		}
	
		public String toString() {
			return String.format("{c='%c', count=%d, childs=%s}", c, count, childs);
		}
	}




	public static void main(String[] args) {
		Trie trie = new Trie();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			
			if (op.equals("add")) {
				trie.add(contact);
				//System.out.println("After adding '" + contact + "': "+trie);
			} else if (op.equals("find")) {
				System.out.println(trie.find(contact));
			} else {
				throw new IllegalArgumentException("Invalid operation: " + op);
			}

							
		}
	}
}

