//min binary heap
public class BinaryHeap
{

	private static class Node
	{
		private int data;
		private Node left;
		private Node right;
		private Node parent;


		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
			parent = null;
		}
	}

	private Node root;
	private Node endNode;

	public int getMinimumValue()
	{
		return root.data;
	}

	public int deleteMin()
	{
		Node endNode = getEndOfHeap(root);
		endNode.left = root.left;
		endNode.right = root.right;
		root = endNode;
		percolateDown(root)

	}

	public int percolateDown(Node node)
	{
		if(node.data < node.left.data)
		{
			percolateDown(node.left)
		}
		if(node.data > node.right.data)
		{
			percolateDown(node.right)
		}


	}

	public void insertNode(int value)
	{
		Node newNode = new Node(value);
		endNode.right = newNode;
		endNode = newNode;
		percolateUp(endNode);
	}


	public int percolateUp(Node node)
	{
		// not sure how to do this.

	}


	public Node getEndOfHeap(Node node)
	{
		if(node.left == null)
		{
			return node.left;
		}
		
		{
			getEndOfHeap(node.right)
		}
		return node
	}

	public void insert(Node node, int value)
	{
		Node finalNode = getEndOfHeap;
		finalNode.left = node;
		node.data = value;

	}




}