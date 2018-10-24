import java.util.*;

// find which node is deeper 
// make them to same height 
// iterate up until they are the same 
public class FirstCommonAncestor
{
	class Node
	{
		int data;
		Node left;
		Node right;
		Node parent;

		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public int compute(Node node1, Node node2)
	{
		int depth1 = getDepth(node1);
		int depth2 = getDepth(node2);

		Node deeperNode = node1;
		Node shallowerNode = node2;
		if(depth2 > depth1)
		{
			deeperNode = node2;
			shallowerNode = node1;
		}

		int difference = Math.abs(depth1-depth2);
		goUpNSteps(shallowerNode, difference);

		node1 = shallowerNode;
		node2 = deeperNode;

		while(node1.data != node2.data && node1 != null && node2 != null)
		{
			node1 = node1.parent;
			node2 = node2.parent;
		}

		if(node1 == null || node2 == null)
		{
			return -1;
		}
		else
		{
			return node1.data;
		}

	}


	public int getDepth(Node node)
	{
		int counter = 0;
		while(node.parent != null)
		{
			node = node.parent;
			counter++;
		}
		return counter;
	}


	public Node goUpNSteps(Node node, int n)
	{
		int counter = 0;
		while(counter < n)
		{
			node = node.parent;
		}
		return node;
	}
}