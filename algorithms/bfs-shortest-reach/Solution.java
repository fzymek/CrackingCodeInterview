import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
       
	int[][] edges; 
        
        public Graph(int size) {
        	edges = new int[size][size];
		for(int i = 0; i < edges.length; i++) {
			Arrays.fill(edges[i], -1);
		}
        }

        public void addEdge(int first, int second) {
         	edges[second][first] = 1;	
		edges[first][second] = 1;   
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
        	Queue<Integer> nodesToVisit = new LinkedList<>();
		int []distances = new int[edges.length];
		Arrays.fill(distances, -1);
		distances[startId] = 0;
		nodesToVisit.add(startId);
		while(!nodesToVisit.isEmpty()) {
			
			int node = nodesToVisit.poll();
			for(int neighbour = 0; neighbour < edges[node].length; neighbour++) {
				if (distances[neighbour] == -1 && edges[node][neighbour] != -1) {
					distances[neighbour] = distances[node] + 6;
					nodesToVisit.add(neighbour);
				}
			}
			

		}

		return distances;


	}

	private boolean shouldVisit(int node, int currentNode, Set<Integer> visitedNodes) {
		return !visitedNodes.contains(node) && edges[currentNode][node] != -1;
	}


	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < edges.length;i++) {
			for(int j =0; j < edges[i].length;j++){
				sb.append(String.format("% d", edges[i][j])).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }

	    //System.out.println(graph); 		
           
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}

