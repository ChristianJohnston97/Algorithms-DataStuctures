
public class AdjacencyList
{

	int vertices;
	// array of linked lists, each element has a list of adjacent vertices
	LinkedList<Integer>[] adjacencyList;

	AdjacencyList(int vertices)
	{
		this.vertices = vertices;
        // initialise the array
		this.adjacencyList = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++)
		{
            // initialise the arrayList
			adjacencyList[i] = new LinkedList();
		}
	}


	public void addEdge(int vertex, int edge)
	{
		adjacencyList[vertex].add(edge);
	}
}




public class AdjacencyListViaNodeClass
{
    public Node[] listOfNodes;

    class Node
    {
        int data;
        Node[] adjacent;
    }
}

public class AdjacencyMatrix
{
    public int[] [] adjacencyMatrix;


}



