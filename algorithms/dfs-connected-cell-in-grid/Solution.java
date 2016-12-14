import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static class Cell {
		int x,y;

		Cell(int i, int j) {
			this.x = i;
			this.y = j;
		}

		public int hashCode() {
			return 13 * x + 11 * y;
		}

		public boolean equals(Object o) {
			if (o instanceof Cell) {
				Cell c = (Cell)o;
				return x == c.x && y == c.y;
			}
			return false;
		}

		public String toString() { return "[" + x +"," + y +"]";}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

	//do magic here
	//int[][]x = hasNeighbours(1,2, grid);	
	//for(int i = 0; i < x.length;i++) {
	//	System.out.print(Arrays.toString(x[i]) + " ");
	//}

	List<Cell> r = searchBiggestRegion(grid);	
	//System.out.println(r.size() + " -> " + r);	
    
	System.out.println(r.size());
}

	static List<Cell> searchBiggestRegion(int [][] grid) {
		List<Cell> biggestRegion = Collections.emptyList();
		HashSet<Cell> visited = new HashSet<>();
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				
				if (grid[i][j] == 0) {
					continue;
				}
				List<Cell> region = findRegionForCell(i, j, grid, visited);
				if (region.size() > biggestRegion.size()) {
					biggestRegion = region;
				}
			}
		}

		
		return biggestRegion;
	}

	static List<Cell> findRegionForCell(int i, int j, int[][]grid, HashSet<Cell> visitedCells) {
		Cell current = new Cell(i,j);
		
		if (visitedCells.contains(current)) {
			//we've been here before -> this means that this cell already belongs to some region
			return Collections.emptyList();
		}
		
		visitedCells.add(current); //visit this cell
		List<Cell> region = new ArrayList<>();
		region.add(current);
		int[][] neighbours = hasNeighbours(i, j, grid);

		//System.out.print("n of (" + i + ", "+ j +")");
		//for(int q = 0; q < neighbours.length;q++) {
		//	System.out.print(Arrays.toString(neighbours[q]) + " ");
		//}
		//System.out.println();
		if (neighbours == null) {
			//no neighbours -> meaning this cell is only one in region
			return region;
		} 

		for (int x = 0; x < neighbours.length; x++) {
			int[] n = neighbours[x];
			region.addAll(findRegionForCell(n[0], n[1], grid, visitedCells));			
		}
		
		return region;		

	}

	static boolean equals(int[] a, int[] b) { return Arrays.equals(a,b); }


	public static int[][] hasNeighbours(int i, int j, int[][]grid) {
		int row = grid.length;
		int col = grid[0].length;

		List<int[]> neighbours = new ArrayList(8); //max number of neighbours
		if (i-1 >= 0) { //check top
			if (grid[i-1][j] == 1) {
				neighbours.add(new int[]{i-1,j});
			}
		}
		
		if (i-1 >= 0 && j+1 < col) { //check top right
			if (grid[i-1][j+1] == 1) {
				neighbours.add(new int[] {i-1,j+1});
			}
		}

		if (j+1 < col) { //check right
			if (grid[i][j+1] == 1) {
				neighbours.add(new int[]{i,j+1});			
			}
		}

		if (i+1 < row && j+1 < col) { //check low righ
			if (grid[i+1][j+1] == 1) {
				neighbours.add(new int[]{i+1, j+1});
			}
		}

		if (i+1 < row) { //check low
			if (grid[i+1][j] == 1) {
				neighbours.add(new int[]{i+1,j});
			}
		}

		if (i+1 < row && j-1 >=0) { //check low left
			if (grid[i+1][j-1] == 1) {
				neighbours.add(new int[] {i+1, j-1});
			}
		}

		if (j-1 >=0 ){ //check left
			if (grid[i][j-1] == 1) {
				neighbours.add(new int[]{i,j-1});
			}
		}
		
		if (i-1 >= 0 && j-1 >= 0) { //check top left
			if(grid[i-1][j-1] == 1){
				neighbours.add(new int[]{i-1,j-1});
			}
		}

		if (neighbours.size() == 0) {
			return null;
		}		
		int [][]n = new int[neighbours.size()][2];
		
		for(int x = 0; x < neighbours.size(); x++) {
			n[x] = neighbours.get(x).clone();
		}

		return n;
	}
}


