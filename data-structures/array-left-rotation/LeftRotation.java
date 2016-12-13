import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

	System.out.println(leftRotation(a,k));
    }


	static String leftRotation(int a[], int k) {

		if (a.length == 1) return ""+a[0];
		
		for (int rotation = 0; rotation < k; rotation++) {
			int carry = a[0];
			for(int i = 0; i <= a.length - 2; i++ ) {
				a[i] = a[i+1];
			}
			a[a.length-1] = carry;

		}

		StringBuilder sb = new StringBuilder();
		for(int i : a) sb.append(i).append(",");
		sb.deleteCharAt(sb.length()-1); //remove last ','
		return sb.toString();

	}

}

