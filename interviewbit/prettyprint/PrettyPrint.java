import java.util.Scanner;


public class PrettyPrint {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		int k = s.nextInt();


		int rows = 2 * k -1;
		int [][] mx = new int[rows][rows];
		

		for(int i = 0; i < k; i++) {
			for(int x = i; x < rows-i; x++) {
				for(int y = i; y < rows-i; y++) {
					mx[x][y] = k - i;
				}			
			
			}

			for (int[] a: mx) {
				for(int b: a) {
					System.out.print(b + " ");
				}
				System.out.println();
			}
		
			System.out.println("====");
		}
	}
}
