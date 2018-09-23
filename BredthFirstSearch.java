import java.util.*;
// Use a QUEUE!

public class BredthFirstSearch
{

	private static class Node
	{
		private int data;
		private Node[] adjacent;
		private boolean visited;

		public Node(int data)
		{
			this.data = data;
		}
	}

	// root of the search
	private Node root;

	public void search(Node root)
	{
		// Linked List implements queue 
		LinkedList<Node> queue = new LinkedList<Node>();
		root.visited = true;
		// add root to the end of the queue 
		queue.add(root);

		while(!queue.isEmpty())
		{
			Node r = queue.remove();
			System.out.println(r.data);
			for(Node n : r.adjacent)
			{
				if(n.visited == false)
				{
					n.visited = true;
					queue.add(n);
				}
			}
		}
	}	
}