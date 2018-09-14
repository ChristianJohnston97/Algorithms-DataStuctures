import java.util.*;

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

	private Node root;

	public void search(Node root)
	{
		LinkedList<Node> queue = new LinkedList<Node>();
		root.visited = true;
		// add root to the end of the queue 
		queue.add(root);

		while(!queue.isEmpty())
		{
			Node r = queue.poll();
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