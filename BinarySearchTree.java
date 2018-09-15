
public class BinarySearchTree
{

	private static class Node
	{
		private int data;
		private Node left;
		private Node right;

		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}

	private Node root;

	public void insertNode(Node node, int value)
	{
		if(value <= node.data)
		{
			insertNode(node.left, value);
		}
		else
		{
			insertNode(node.right, value);
		}

	}

	public int findMinimumValue(Node node)
	{
		Node current = node;
		
		while(current.left != null)
		{
			current = current.left;
		}
		return current.data;
	}


	public boolean search(Node node, int value)
	{
		if(node.data == value)
		{
			return true;
		}

		if(value >= node.data)
		{
			search(node.right, value);
		}
		else
		{
			search(node.left, value);
		}
		return false;
	}


	public Node delete(Node node, int value)
	{
		if (value < root.data)
            root.left = delete(root.left, value);
        else if (value > root.data)
            root.right = delete(root.right, value);
		else
		{
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.right;
			}
			root.data = minValue(root.right);
			root.right = delete(root.right, root.data);

		}
		return root;
	}

	public int minValue(Node root)
	{
		int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
	}

}