import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

	System.out.println(sort(a));
	System.out.println("First Element: " + a[0]);
	System.out.println("Last Element: " + a[a.length-1]);
    }


	static String sort(int []data) {
		int totalSwaps = 0;

		for(int i = 0; i < data.length; i++) {
			int swaps = 0;
			for(int j = 0; j < data.length -1 ;j++) {
				if (data[j] > data[j+1]) {
					int t = data[j];
					data[j] = data[j+1];
					data[j+1] = t;
					swaps++;
				}
			}
			totalSwaps+=swaps;
		}
	
		return "Array is sorted in " + totalSwaps + " swaps.";
	}
}
