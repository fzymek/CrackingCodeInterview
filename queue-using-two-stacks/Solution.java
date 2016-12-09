import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> N  = new Stack<T>();
        Stack<T> O  = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
		N.push(value);		
	 }

        public T peek() {
		
		if (O.empty()) copy();

		return O.peek();
        }

        public T dequeue() {
		if (O.empty()) copy();
		return O.pop();
        }	

	private void copy() {
		while(!N.empty()) O.push(N.pop());
	}
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

