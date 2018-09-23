// depth first search is ITERATIVE 
// must check to see if a node has been visited;
public class DepthFirstSearch
{

	private class Node<Integer>
	{
		private int data;
		private Node[] adjacent;
		private boolean visited;

		public Node(int data)
		{
			this.data = data;
			this.visited = false;
		}
	}
	// root of search
	private Node root;

	public void search(Node root)
	{
		if(root == null) return;
		System.out.println(root.data);
		root.visited = true;
		for(Node n : root.adjacent)
		{
			if(n.visited == false)
			{
				search(n);
			}
		}
	}

	
}