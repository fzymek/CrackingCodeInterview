import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static class IceCream {
		final int id;
		final int cost;

		IceCream(int id, int cost) {
			this.id = id + 1;
			this.cost = cost;
		}

		public String toString() {
			return "[" + id + ", $"+ cost +"]";
		}

	}

	static class IceCreamComparator implements Comparator<IceCream> {
		
		public int compare(IceCream iceCream1, IceCream iceCream2) {
			//System.out.println("comparing: "+ iceCream1 + " to " + iceCream2);
			if (iceCream1.cost == iceCream2.cost) {
				return 0;//iceCream1.id - iceCream2.id;
			} else {
				return iceCream1.cost - iceCream2.cost;
			}
		}

	}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
	IceCreamComparator comparator = new IceCreamComparator();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            IceCream iceCreams[] = new IceCream[n];
            for(int a_i=0; a_i < n; a_i++){
                iceCreams[a_i] = new IceCream(a_i, in.nextInt());
            }
		
		//System.out.println(Arrays.toString(iceCreams));
		Arrays.sort(iceCreams, comparator);	
		//System.out.println(Arrays.toString(iceCreams));

		System.out.println(findIceCreamsForMoney(m, iceCreams));
        }
    }

	public static String findIceCreamsForMoney(int m, IceCream[] iceCreams) {
		
		for (int i = 0; i < iceCreams.length; i++) {
			
			IceCream ice = iceCreams[i];
			int moneyLeft = m - ice.cost;
			//System.out.println("Looking for ice cream with cost: " + moneyLeft + "in : "+ Arrays.toString(iceCreams));
			IceCream toSearch = new IceCream(Integer.MAX_VALUE, moneyLeft);
			int foundIndex = Arrays.binarySearch(iceCreams, i+1, iceCreams.length, toSearch, new IceCreamComparator());
			
			if (foundIndex >= 0) {
				IceCream found = iceCreams[foundIndex];
				return "" + Math.min(ice.id, found.id) + " " + Math.max(ice.id, found.id);
			}
		}
	
		return "Not found";	
	}
}
