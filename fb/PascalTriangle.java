import java.util.*;

public class PascalTriangle {
	public static  ArrayList<Integer> getRow(int a) {
	    
	    if (a == 0) {
	        return new ArrayList(Arrays.<Integer>asList(1));
	    }
	    Integer [] row = new Integer[a+1];
	    ArrayList<Integer> prev = getRow(a-1);
	    for(int i = 0; i < row.length; i++) {
	        
	        if (i == 0 || i == row.length-1) {
	            int k = prev.get(0);
	            row[i] = k;
	        }
	        else {
	            int v = prev.get(i) + prev.get(i-1);
	            row[i] = v;
	        }
	    }
	    
	    ArrayList<Integer> n = new ArrayList(Arrays.<Integer>asList(row));
	    return n;
	    
	}

	public static void main(String ...args) {
		System.out.println(getRow(Integer.parseInt(args[0])));
	}
}

