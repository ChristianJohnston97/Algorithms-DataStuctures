// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of 
// vertices such that for every directed edge uv, vertex u comes before v in the ordering. 

// The first vertex in topological sorting is always a vertex with in-degree = 0

// similar to DFS 

// Use a temporary stack. 
// First recursively call topological sorting for all its adjacent vertices, 
// then push it to a stack. Finally, print contents of stack. 

// Note that a vertex is pushed to stack only when all of its adjacent vertices 
// (and their adjacent vertices and so on) are already in stack.
import java.util.*;

// O(V+E).
public class TopologicalSort
{

	int vertices;
	// array of linked lists, each element has a list of adjacent vertices
	LinkedList<Integer>[] adjacencyList;

	TopologicalSort(int vertices)
	{
		this.vertices = vertices;
		this.adjacencyList = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++)
		{
			adjacencyList[i] = new LinkedList();
		}
	}


	public void addEdge(int vertex, int edge)
	{
		adjacencyList[vertex].add(edge);
	}

	  // A recursive function used by topologicalSort 
    public void topologicalSortUtil(int vertex, boolean[] visited, Stack stack) 
    { 
        // Mark the current node as visited. 
        visited[vertex] = true; 

        // recurse all adjacent nodes  
        for(Integer node: adjacencyList[vertex])
        {
        	if(!visited[node])
        	{
        		 topologicalSortUtil(node, visited, stack); 
        	}
        }

        // Push current vertex to stack which stores result 
        stack.push(new Integer(vertex)); 
    } 
  
    void topologicalSort() 
    { 
        Stack stack = new Stack(); 
  
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[vertices]; 
        for (int i = 0; i < vertices; i++) 
        {
            visited[i] = false; 
        }
  
        // Call the recursive helper function to store 
        // Topological Sort starting from all vertices 
        // one by one 
        for (int i = 0; i < vertices; i++)
        {
 			if (visited[i] == false)
 			{
 				topologicalSortUtil(i, visited, stack); 
 			}
        } 
          
        // Print contents of stack 
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " "); 
        }
    } 



	public static void main(String[] args)
	{
		TopologicalSort g = new TopologicalSort(6); 
		g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 

        g.topologicalSort(); 
	}


}