import java.io.*; import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
	
	/** holds lower half of numbers in increasing order */
	PriorityQueue<Integer> higher = new PriorityQueue<>();
	
	/** holder upper half of numbers in decreasing order */
	PriorityQueue<Integer> lower = new PriorityQueue<>((l, r) -> -1 * l.compareTo(r));
        	

	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
		int val = in.nextInt();
		addValue(val, lower, higher);
		//System.out.println("lower: "+ lower + "\nhigher: "+ higher);
		rebalance(lower, higher);
		//System.out.println("after rebalance lower: "+ lower + "\nhigher: "+ higher);
		System.out.println(getMedian(lower, higher));
        }
    }


	static void addValue(int val, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		if (lower.isEmpty()) {
			lower.add(val);
			return;
		}

		if (val > lower.peek()) {
			higher.add(val);
		} else {
			lower.add(val);
		}
	
	}

	static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smaller  = lower.size() > higher.size() ? higher : lower;


		if (bigger.size() - smaller.size() >= 2) {
			smaller.add(bigger.poll());
		}
	
	}
	
	static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smaller  = lower.size() > higher.size() ? higher : lower;

		if (bigger.size() == smaller.size()) {
			return (bigger.peek() + smaller.peek()) / 2.0;
		}

		return bigger.peek() * 1.0;
		
	}
}

