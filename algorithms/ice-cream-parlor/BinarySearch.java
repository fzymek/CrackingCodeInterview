import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;

public class BinarySearch {

	
	public static <T extends Comparable<T>> int binarySearch(T elem, T[]data) {
		return search(elem, data, 0, data.length-1);
	}


	private static <T extends Comparable<T>> int search(T elem, T[] data, int start, int end) {
		//System.out.println("search(" + elem + ", " + Arrays.toString(data) + ", "+ start + ", "+ end +")");
		if (start >= end) {
			//we are at end
			if (data[start].equals(elem)) {
				return start;
			}
			else {
				return -1;
			}
		}

		int mid = (end + start) / 2;
		//System.out.println(mid);
		int res = data[mid].compareTo(elem);  
		if (res == 0) {
			return mid;
		} else if(res > 0) {
			//mid elem is bigger - search in left half
			return search(elem, data, start, mid-1);
		} else {
			return search(elem, data, mid+1, end);
		}

	}

	
	public static void main(String [] args) {
		/*
		File f = new File("input.txt");
		try {
			try(PrintStream ps = new PrintStream(new FileOutputStream(f))) {
				ps.print(300000);
				ps.print("\n");
				for(int i =0;i < 300000; i++) {
					ps.print(i);
					ps.print(" ");
				}
				ps.flush();

			}
			
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		*/


		Scanner s = new Scanner(System.in);
		int countElems = s.nextInt();
		s.nextLine();
		Integer[] data = new Integer[countElems];
		for(int i = 0; i < countElems; i++) {
			data[i] = s.nextInt();
		} 		
		s.nextLine();
		Integer toBeFound = s.nextInt();


		int index = BinarySearch.binarySearch(toBeFound, data);
		if (index >=0) {
			System.out.println(String.format(
				"Lost element %d is found at place %d and has value %d", toBeFound, index, data[index]
			));
		} else {
			System.out.println("Lost element not found in data");
		}
	
	
	}

}
