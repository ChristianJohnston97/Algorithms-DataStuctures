import java.util.*;

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

	// function to find lowest common ancestor between nodes n1 and n2
	public Node lowestCommonAncestor(Node node, int n1, int n2)
	{
		if(node == null)
		{
			return null;
		}

		if(node.data > n1 && node.data > n2)
		{
			return lowestCommonAncestor(node.left, n1, n2);
		}

		if(node.data < n1 && node.data < n2)
		{
			return lowestCommonAncestor(node.right, n1, n2);
		}
		return Node;
	}		

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

	// in order is left first
	// pre order is node first then left then right
	// post order is left then right then node
	public void inOrderTreversal(Node root)
	{
		if(root != null)
		{
			inOrderTreversal(root.left);
			System.out.println(root.data);
			inOrderTreversal(root.right);
		}
	}


	// level order = breadth first search (use a queue)
	// LinkedList is best implementation of queue interface
	// BFS is NOT iterative!

	public void levelOrderTreversal(Node root)
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			Node frontOfQueue = queue.remove();
			System.out.println(frontOfQueue.data);
			if(frontOfQueue.left != null)
			{
				queue.add(frontOfQueue.left);
			}
			if(frontOfQueue.right != null)
			{
				queue.add(frontOfQueue.right);
			}
		}
	}
}