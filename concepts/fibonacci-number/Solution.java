import java.util.*;

public class Solution {

    
    public static int fibonacci(int n, int [] cache) {
        // Complete the function.
	if (n == 0) return 0;
	if (n <= 2) return 1;
	
	int val = cache[n];
	if (val == 0) {
		val = fibonacci(n-1, cache) + fibonacci(n-2, cache);
		cache[n] = val;
	}

	return val;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
	int []numbersCache = new int[n+1];
        System.out.println(fibonacci(n, numbersCache));
    }
}

