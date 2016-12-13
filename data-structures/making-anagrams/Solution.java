import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
	
	int [] histA = new int[26];
	int [] histB = new int[26];

	for(int i = 0; i < first.length(); i++) {
		histA[first.charAt(i)-'a']++;
	}	  	

	for(int i = 0; i < second.length(); i++) {
		histB[second.charAt(i)-'a']++;
	}


	int del = 0;
	for(int i = 0; i < 26; i++) {
		del += Math.abs(histA[i] - histB[i]);
	}

	return del;
    
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
