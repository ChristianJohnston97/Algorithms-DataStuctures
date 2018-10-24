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

	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        tree.secondLargestNode(50);
	}


	private Node root;
	private int counter;


	public void secondLargestNode(Node node)
	{
		if(root != null)
		{
			if(root.right != null)
			{
				secondLargestNode(root.right);
			}
			
			counter++;
			if(counter == 2)
			{
				System.out.println(root.data);
			}
			
			if(root.left != null)
			{
				secondLargestNode(root.left);
			}
		}
	}

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
		return node;
	}



	public Node inesert(Node root, int key) { 
  
        /* If the tree is empty, return a new node */
        if (root == null) 
        { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.key)
        {
            root.left = insertRec(root.left, key); 
        }
        else if (key > root.key)
        {
            root.right = insertRec(root.right, key); 
        }
  
        return root; 
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

		else if(value > node.data)
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
			// node with only one child or no child 
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right == null)
			{
				return root.left;
			}
			// node with two children, get the smallest in the right subtree
			root.data = minValue(root.right);

			//delete the smallest node in the right subtree
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
			if(root.left != null)
			{
				inOrderTreversal(root.left);
			}

			System.out.println(root.data);
			
			if(root.right != null)
			{
				inOrderTreversal(root.right);
			}
		}
	}


	// level order = breadth first search (use a queue)
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