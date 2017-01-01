import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
		int []memo = new int[n+1];
		System.out.println(countWaysToClimb(n, memo));
        }
    }

	static int countWaysToClimb(int n, int[] memo) {

		if (n <= 0) return 0;
		if (n == 1) return 1;

		int v = memo[n];
		if (v == 0) {
			v = countWaysToClimb(n-1, memo) + countWaysToClimb(n-2, memo) + countWaysToClimb(n-3, memo);
			memo[n] = v; 

		}

		return v;	
	}
}

