import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

	System.out.println(canWriteRansomNote(magazine, ransom) ? "Yes": "No");
    }


	public static boolean canWriteRansomNote(String mag[], String note[]) {
		Arrays.sort(mag);
		Arrays.sort(note);
		List<String> dict = new ArrayList<>(mag.length);
		for (String s: mag) dict.add(s);

		for (String s : note) { 
			if (!dict.contains(s)) { 
				return false;	
			}
			else {
				dict.remove(s);
			}
		}	 

		return true;
	}
}

