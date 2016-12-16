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
		System.out.println(countWaysToClimb(n));
        }
    }

	static int countWaysToClimb(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;

		return countWaysToClimb(n-1) + countWaysToClimb(n-2) + countWaysToClimb(n-3); 
	
	}
}

