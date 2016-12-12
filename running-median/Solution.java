import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	//TODO: use priority queues
	
    public static void main(String[] args) {

	MaxHeap max;
	MinHeap min;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
	max = new MaxHeap();
	min = new MinHeap();
        for(int a_i=0; a_i < n; a_i++){
		a[a_i] = in.nextInt();


		if (min.size < 1) {
			min.add(a[a_i]);
		} else {
			
			if (min.size > max.size) {
				if (min.peek() > a[a_i]) {
					max.add(min.poll());
					min.add(a[a_i]);
				} else {
					max.add(a[a_i]);
				}
			} else {
				if (max.peek() > a[a_i]) {
					min.add(a[a_i]);
				} else {
					min.add(max.poll());
					max.add(a[a_i]);
				}

			}


		}


		if (((min.size + max.size) % 2) == 0) {
			System.out.println(String.format("%.1f", (min.peek() + max.peek()/2.0) ));
		} else {
			System.out.println(String.format("%.1f", (1.0 * min.peek())));
		}


        }
    }
}





/** Heap of ints **/
abstract class Heap {
    /** Current array length **/
    protected int capacity;
    /** Current number of elements in Heap **/
    protected int size;
    /** Array of Heap elements **/
    protected int[] items;

    public Heap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }
    
    /** @param parentIndex The index of the parent element.
        @return The index of the left child.
    **/
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    /** @param parentIndex The index of the parent element.
        @return The index of the right child.
    **/
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    
    /** @param childIndex The index of the child element.
        @return The index of the parent element.
    **/
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    /** @param index The index of the element you are checking.
        @return true if the Heap contains enough elements to fill the left child index, 
                false otherwise.
    **/
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    
    /** @param index The index of the element you are checking.
        @return true if the Heap contains enough elements to fill the right child index, 
                false otherwise.
    **/
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    
    /** @param index The index of the element you are checking.
        @return true if the calculated parent index exists within array bounds
                false otherwise.
    **/
    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    
    /** @param index The index of the element whose child you want.
        @return the value in the left child.
    **/
    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }
    
    /** @param index The index of the element whose child you want.
        @return the value in the right child.
    **/
    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    
    /** @param index The index of the element you are checking.
        @return the value in the parent element.
    **/
    public int parent(int index) {
        return items[getParentIndex(index)];
    }
    
    /** @param indexOne The first index for the pair of elements being swapped.
        @param indexTwo The second index for the pair of elements being swapped.
    **/
    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    /** Doubles underlying array if capacity is reached. **/
    public void ensureCapacity() {
        if(size == capacity) {
            capacity = capacity << 1;
            items = Arrays.copyOf(items, capacity);
        }
    }
    
    /** @throws IllegalStateException if Heap is empty.
        @return The value at the top of the Heap.
     **/
    public int peek() {
        isEmpty("peek");
        
        return items[0];
    }
    
    /** @throws IllegalStateException if Heap is empty. **/
    public void isEmpty(String methodName) {
        if(size == 0) {
            throw new IllegalStateException(
                "You cannot perform '" + methodName + "' on an empty Heap."
            );
        }
    }
    
    /** Extracts root element from Heap.
        @throws IllegalStateException if Heap is empty.
    **/
    public int poll() {
        // Throws an exception if empty.
        isEmpty("poll");
        
        // Else, not empty
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }
    
    /** @param item The value to be inserted into the Heap. **/
    public void add(int item) {
        // Resize underlying array if it's not large enough for insertion
        ensureCapacity();
        
        // Insert value at the next open location in heap
        items[size] = item;
        size++;
        
        // Correct order property
        heapifyUp();
    }
    
    /** Swap values down the Heap. **/
    public abstract void heapifyDown();
    
    /** Swap values up the Heap. **/
    public abstract void heapifyUp();
}


class MaxHeap extends Heap {

	/**
		Enusre max element is on top 
	*/
	public void heapifyUp() {
		int index = size - 1; //get last element
		while (hasParent(index) && items[index] > parent(index)) {
			//move element up in heap to satisfy ordering
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {
		
		int index = 0; //start at top;
		while (hasLeftChild(index)) {
			int currentMinIndex = getLeftChildIndex(index);

			if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
				currentMinIndex = getRightChildIndex(index);
			}
	
			if (items[index] > items[currentMinIndex]) {
				break;
			} else {
				swap(index, currentMinIndex);
			}

			index = currentMinIndex;
		}		


	}	

}

class MinHeap extends Heap {

	public void heapifyUp() {
		
		int index = size - 1;

		while (hasParent(index) && items[index] < parent(index)) {
			swap (getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {

		int index = 0;

		while (hasLeftChild(index)) {
			int currentMaxIndex = getLeftChildIndex(index);

			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				currentMaxIndex = getRightChildIndex(index);
			}

			if (items[index] < items[currentMaxIndex]) {
				break;
			} else {
				swap(index, currentMaxIndex);
			}
			
			index = currentMaxIndex;		
	
		}

	}

}






