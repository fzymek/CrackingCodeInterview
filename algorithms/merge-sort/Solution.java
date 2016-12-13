import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }

		System.out.println(mergeSort(arr, 0, arr.length-1));
		//System.out.println(Arrays.toString(arr));
        }

    }


	public static int mergeSort(int[] data, int start, int end) {
		//System.out.println(String.format("mergeSort(%s, %d, %d)", Arrays.toString(data), start, end));		
		if (start >= end) {
			//nothing to sort
			return 0;
		}

		int mid = (start + end) / 2;
		

		mergeSort(data, start, mid);
		mergeSort(data, mid+1, end);	
		merge(data, start, end);
		//System.out.println(Arrays.toString(data));
		return 0;

	}


	public static void merge(int[] data, int start, int end) {
		//System.out.println(String.format("merge(%s, %d, %d)",Arrays.toString(data), start, end));	

		int tmp[] = new int[end - start + 1];
		int mid = (start + end)/2;
		int lpos, rpos, tmppos;
		lpos = start;
		rpos = mid + 1;
		tmppos = 0;
		
		while(lpos <= mid && rpos <= end) {
			if (data[lpos] > data[rpos]) {
				tmp[tmppos++] = data[rpos++];
			} else {
				tmp[tmppos++] = data[lpos++];
			}
		}

		while (lpos <= mid) {
			tmp[tmppos++] = data[lpos++];
		}

		while(rpos <= end) {
			tmp[tmppos++] = data[rpos++];
		}

		System.arraycopy(tmp, 0, data, start, end - start +1);
		
	}
}
